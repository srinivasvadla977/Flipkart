package com.mycreation.flipkart.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "ALL_IS_WELL_ALL_IS_WELL_ALL_IS_WELL";
    private final Key KEY= Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String generateToken (String email, List<String> roles){

        return Jwts.builder()
                .setSubject(email)
                .claim("roles",roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractEmail_fromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public List<String> extractRoles_fromToken(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.get("roles",List.class);
    }

}
