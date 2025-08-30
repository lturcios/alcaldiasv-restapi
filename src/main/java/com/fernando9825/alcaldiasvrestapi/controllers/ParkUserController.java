package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Parkusuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IParkUserService;
import com.fernando9825.alcaldiasvrestapi.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/")
public class ParkUserController {

    private final IParkUserService parkuserService;
    private final JWTUtil jwtUtil = new JWTUtil();

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
                parkusuario.setLastAction("login");
                parkuserService.save(parkusuario);
                String token = jwtUtil.getJWTToken(email);
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

    @PostMapping("parkuser/logout")
    public ResponseEntity<?> logout(
            @RequestParam("email") String email
    ){
        System.out.println("email: " + email);
        Parkusuario parkusuario = parkuserService.findById(email);
        Map<String, Object> response = new HashMap<>();

        if(parkusuario != null){
            parkusuario.setLastAction("logout");
            parkuserService.save(parkusuario);
            response.put("message", "User logged out successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }

        response.put("error", "User not found!");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
