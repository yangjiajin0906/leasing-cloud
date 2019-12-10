package com.leasing.common.utils.base;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenUtil {

    final static String base64EncodedSecretKey = "jic-leasing";//私钥

    final static long TOKEN_EXP = 1000 * 60 * 10;//过期时间,使用十分钟

    /**
     * Token生成工具類
     * @param userName
     * @return
     */
    public static String getToken(String userName) {
    return Jwts.builder()
        .setSubject(userName)
        .claim("roles", "user")
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXP)) /*过期时间*/
        .signWith(SignatureAlgorithm.HS256, base64EncodedSecretKey)
        .compact();
    }

}
