package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String jwtSecret = "mySecretKey12345";
    private final long jwtExpirationMs = 86400000; // 1 day

    // ================= CREATE TOKEN =================
    public String generateToken(Authentication authentication, com.example.demo.entity.User user) {

        return Jwts.builder()
                .setSubject(user.getEmail())   // EMAIL is subject
                .claim("userId", user.getId())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    // ================= EXTRACT USERNAME / EMAIL =================
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // ⭐ REQUIRED BY JwtAuthenticationFilter
    public String getEmailFromToken(String token) {
        return getUsernameFromToken(token);
    }

    // ================= USER ID =================
    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.get("userId", Long.class);
    }

    // ================= VALIDATION =================
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
