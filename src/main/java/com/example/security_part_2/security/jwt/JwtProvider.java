package com.example.security_part_2.security.jwt;

import com.example.security_part_2.security.userprincal.UserPrinciple;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private  static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private  String jwtSecret = "hoangtrungkiet07072002hoangtrungkiet07072002hoangtrungkiet07072002hoangtrungkiet07072002hoangtrungkiet07072002hoangtrungkiet07072002hoangtrungkiet07072002";
    private int jwtExpriration = 86400;

    public String createToken(Authentication authentication){
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return Jwts.builder().setSubject(userPrinciple.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + jwtExpriration * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token);
        }catch (SignatureException e){
            logger.error("JWT signature -> Message: {}", e);
        }catch (MalformedJwtException e){
            logger.error("Token invalid format -> Message: {}", e);
        }catch(ExpiredJwtException e){
            logger.error("Exporied JWT token -> Message: {}", e);
        }catch (UnsupportedJwtException e){
            logger.error("Unsupport JWT -> Message: {}", e);
        }catch (IllegalArgumentException e){
            logger.error("JWT claims string is empty -> Message: {}", e);
        }

        return false;
    }

    public String getUserNameFromToken(String token){
        String username = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token).getBody().getSubject();
        return username;
    }
}
