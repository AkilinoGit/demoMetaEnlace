package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    private final static String ACCES_TOKEN_SECRET = "7d6a4e354a4da2cfebc234cb237ec08c5c73f74cc6c82cc33379550e9e9822e6";
    private final static Long ACCES_TOKEN_VALIDITY_SECONDS = 2_592_000L; //30DÍAS


    //CREA TOKEN
    public static String createToken(String nombre, String usuario){
        long expirationTime = ACCES_TOKEN_VALIDITY_SECONDS * 1_000;//PARA PASARLO A SEGUNDOS
        Date expiratedDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String,Object> extra = new HashMap<>();
        extra.put("nombre",   nombre);

        return Jwts.builder()
                .setSubject(usuario)
                .setExpiration(expiratedDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
                .compact();

    }


    //OBTIENE USUARIO A PARTIR DEL TOKEN SACANDO LA INFORMACIÓN A CLAIMS
    public static UsernamePasswordAuthenticationToken getAuthentication(String token){

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCES_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String usuario = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(usuario, null, Collections.emptyList());
        } catch (JwtException   e){ // POR SI TOKEN CADUCACO
            return null;
        }
    }


}
