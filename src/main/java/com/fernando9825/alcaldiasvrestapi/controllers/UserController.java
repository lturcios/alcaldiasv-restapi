package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.Usuario;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.IUserService;
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
public class UserController {

    private final IUserService userService;
    private JWTUtil jwtUtil = new JWTUtil();

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("user" )
    public ResponseEntity<?> login(@RequestParam("email") String email,
                                   @RequestParam("password") String pwd,
                                   @RequestParam(required = false, name = "deviceid") String deviceid) {

        Usuario usuario = userService.findById(email);
        Map<String, Object> response = new HashMap<>();

        if (usuario != null) {
            if (pwd.equals(usuario.getPassword())) {
                // generar el token
                String token = jwtUtil.getJWTToken(email);

                response.put("message", "Please use the given token in every request, in order to " +
                        "get access to all API");
                response.put("nombre", usuario.getNombre());
                response.put("email", email.trim());
                response.put("token", token);
                response.put("institucion", usuario.getInstitucion());
                // if(deviceid == null) deviceid = ""; // old version doesn't send this value, then replace to empty
                userService.save(usuario);
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            }
        }
        response.put("error", "email or password incorrect!");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PostMapping({"user/logout", "diveruser/logout"})
    public ResponseEntity<?> logout(@RequestParam("email") String email){
        Usuario usuario = userService.findById(email);
        Map<String, Object> response = new HashMap<>();

        if(usuario != null){
            // userService.save(usuario);
            response.put("message", email + " logged out!");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        response.put("error", "email incorrect!");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
