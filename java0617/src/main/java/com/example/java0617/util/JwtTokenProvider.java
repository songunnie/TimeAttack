package com.example.java0617.util;

import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import java.util.Date;

public class JwtTokenProvider {

    private static final String SECRET_KEY = "secret";
    private static final int EXPIRATION_MS = 3600000;

    public static String generateToken(Authentication authentication) {
        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + EXPIRATION_MS);

        return Jwts.builder()
                .setSubject((String) authentication.getPrincipal())
                .setIssuedAt(currentDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.H256, SECRET_KEY)
                .compact();
    }

    public static String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            System.out.println("JWT 예외 발생");
        }

        return false;
    }
}
