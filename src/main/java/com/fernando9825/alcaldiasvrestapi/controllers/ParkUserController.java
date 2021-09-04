package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parkusuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkUserService;
import com.fernando9825.alcaldiasvrestapi.security.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/")
public class ParkUserController {

    private final IParkUserService parkuserService;

    @Autowired
    public ParkUserController(IParkUserService parkuserService) {
        this.parkuserService = parkuserService;
    }

    @PostMapping("parkuser")
    public ResponseEntity<?> login(
            @RequestParam("email") String email,
            @RequestParam("password") String pwd
    ){
        Parkusuario parkusuario = parkuserService.findById(email);
        Map<String, Object> response = new HashMap<>();

        if(parkusuario != null){
            if(pwd.equals(parkusuario.getPassword())){
                //Llega el momento de generar el token
                String token = getJWTToken(email);

                response.put("message", "Please use the given token in every request, in order to " +
                        "get access to all API");
                response.put("nombre", parkusuario.getNombre());
                response.put("email", parkusuario.getEmail());
                response.put("token", token);
                response.put("institucion", parkusuario.getInstitucion());
                response.put("ubicacion", parkusuario.getUbicacion());
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            }
        }

        response.put("error", "email or password incorrect!");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    private String getJWTToken(String username) {

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(SecurityConstants.ROLE_USER);

        String token = Jwts
                .builder()
                .setId(SecurityConstants.JWT_ID)
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512,
                        SecurityConstants.JWT_SECRET.getBytes()).compact();

        return SecurityConstants.PREFIX + token;
    }

}
