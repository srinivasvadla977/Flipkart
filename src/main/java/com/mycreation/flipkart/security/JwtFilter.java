package com.mycreation.flipkart.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader!=null && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring(7);

            String email = jwtUtil.extractEmail_fromToken(token);
            List<String> roles = jwtUtil.extractRoles_fromToken(token);

            if (!email.isEmpty()){

                if (roles.isEmpty()){
                    SecurityContextHolder.getContext().setAuthentication(new PreAuthenticatedAuthenticationToken(email,null,null ));
                }
                else{
                    List<SimpleGrantedAuthority> authorities = roles.stream().map(SimpleGrantedAuthority::new).toList();

                    UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(email,null,authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }

            }

        }

        filterChain.doFilter(request,response);

    }
}
