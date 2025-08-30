package com.fernando9825.alcaldiasvrestapi.controllers;

import com.fernando9825.alcaldiasvrestapi.models.entity.TuriUser;
import com.fernando9825.alcaldiasvrestapi.models.services.interfaces.ITuriUserService;
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
public class TuriUserController {

    private final ITuriUserService turiuserService;
    private final JWTUtil jwtUtil = new JWTUtil();

    @Autowired
    public TuriUserController(ITuriUserService turiuserService) {
        this.turiuserService = turiuserService;
    }

    @PostMapping( "turiuser")
    public ResponseEntity<?> login(
            @RequestParam("email") String email,
            @RequestParam("password") String pwd
    ){
        TuriUser turiUser = turiuserService.findById(email);
        Map<String, Object> response = new HashMap<>();

        if(turiUser != null){
            if(pwd.equals(turiUser.getPassword())){
                String token = jwtUtil.getJWTToken(email);
                response.put("message", "Login successful");
                response.put("email", turiUser.getUsuario());
                response.put("nombre", turiUser.getNombre());
                response.put("token", token);
                response.put("ubicacion", turiUser.getUbicacion());
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            }
        }

        response.put("error", "Invalid credentials");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }



}
