package com.fernando9825.alcaldiasvrestapi.config;

import com.fernando9825.alcaldiasvrestapi.security.JWTAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/user").permitAll()
                .antMatchers(HttpMethod.POST, "/api/user/logout").permitAll()
                .antMatchers(HttpMethod.POST, "/api/saniuser").permitAll()
                .antMatchers(HttpMethod.POST, "/api/parkuser").permitAll()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .anyRequest().authenticated();
    }
}
