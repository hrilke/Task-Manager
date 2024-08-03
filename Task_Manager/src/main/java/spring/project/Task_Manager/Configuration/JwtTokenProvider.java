package spring.project.Task_Manager.Configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenProvider {
    private final String JWT_SECRET_KEY = "1q2w3e4r5t6y7u8i9o0p";
    private final long JWT_EXPIRE = 86400000;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRE))
                .signWith(SignatureAlgorithm.ES256,JWT_SECRET_KEY)
                .compact();
    }

    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    public boolean validateToken(String token){
        return getClaimsFromToken(token).getExpiration().before(new Date());
    }
}
