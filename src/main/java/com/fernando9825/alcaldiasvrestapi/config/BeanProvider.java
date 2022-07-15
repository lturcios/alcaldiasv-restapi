package com.fernando9825.alcaldiasvrestapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Bean
    public String jwtSecret() {
        return jwtSecret;
    }

}
