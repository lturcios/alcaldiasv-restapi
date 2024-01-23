package com.fernando9825.alcaldiasvrestapi.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@PropertySource("classpath:application.properties")
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public final String HEADER = "Authorization";


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            if (checkJWTToken(request, response)) {
                Claims claims = validateToken(request);
                if (claims.get("authorities") != null) {
                    setUpSpringAuthentication(claims);
                } else {
                    SecurityContextHolder.clearContext();
                }
            }
            chain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
            return;
        }
    }

    private Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(HEADER).replace(SecurityConstants.PREFIX, "");
        return Jwts.parser()
                .setSigningKey(SecurityConstants.JWT_SECRET.getBytes())
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    /**
     * Authentication method in Spring flow
     * <p>
     *     This method is used to authenticate the user in the Spring flow.
     *     It uses the {@link SecurityContextHolder} to set the authentication
     *     token in the context.
     *     <br>
     *     The {@link UsernamePasswordAuthenticationToken} is used to set the
     *     authentication token in the context.
     *     <br>
     *     The {@link SimpleGrantedAuthority} is used to set the authorities
     *     in the context.
     *     <br>
     *     The {@link Claims} is used to get the claims from the JWT token.
     *     <br>
     *     The {@link List} is used to get the list of authorities from the
     *     claims.
     *     <br>
     * @since 1.0
     * @see SecurityContextHolder
     * @see UsernamePasswordAuthenticationToken
     * @see SimpleGrantedAuthority
     * @see Claims
     * @see List
     * @see Collectors
     * @see SecurityConstants
     * @see SecurityConstants#PREFIX
     * @see SecurityConstants#JWT_SECRET
     */
    private void setUpSpringAuthentication(Claims claims) {
        @SuppressWarnings("unchecked")
        List<String> authorities = (List<String>) claims.get("authorities");

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
                authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        SecurityContextHolder.getContext().setAuthentication(auth);

    }

    private boolean checkJWTToken(HttpServletRequest request, HttpServletResponse res) {
        String authenticationHeader = request.getHeader(HEADER);
        if (authenticationHeader == null || !authenticationHeader.startsWith(SecurityConstants.PREFIX))
            return false;
        return true;
    }
}
