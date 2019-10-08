package com.fernando9825.alcaldiasvrestapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecurityConstants {

    public final static String ROLE_USER = "ROLE_USER";
    public final static String JWT_ID = "fernando9825JWT";

    public final static String PREFIX = "Bearer ";

    public static String JWT_SECRET;

    @Autowired
    public SecurityConstants(String jwtSecret) {
        SecurityConstants.JWT_SECRET = jwtSecret;
    }

}
