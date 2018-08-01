package com.loan.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;

public class TokenSecurity {

    /**
     * 由字符串生成加密key
     * */
    public static SecretKey generalKey(String stringKey) throws UnsupportedEncodingException {
        byte[] encodedKey = stringKey.getBytes("UTF-8");
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 创建token
     * */
    public static String createToken(long ttlMillis, String stringKey, String id) throws UnsupportedEncodingException {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long noMillis = System.currentTimeMillis();
        Date now = new Date(noMillis);
        SecretKey key = generalKey(stringKey);

        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuedAt(now)
                //.setSubject("{name:lin}")
                .signWith(signatureAlgorithm, key);

        if(ttlMillis > 0){
            long expMillis = noMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 解密token
     * @param token
     * @return
     * @throws Exception
     */
    public static Claims validateToken(String token, String stringKey) throws Exception{
        Claims claims = Jwts.parser()
                .setSigningKey(generalKey(stringKey))
                .parseClaimsJws(token)
                .getBody();
//        System.out.println("ID: " + claims.getId());
//        System.out.println("Subject: " + claims.getSubject());
//        System.out.println("Issuer: " + claims.getIssuer());
//        System.out.println("Expiration: " + claims.getExpiration());
        return claims;
    }
}