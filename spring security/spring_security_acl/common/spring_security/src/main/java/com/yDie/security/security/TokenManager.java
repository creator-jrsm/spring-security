package com.yDie.security.security;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *  根据用户名生成token的工具类
 *  使用jwt
 */
@Component
public class TokenManager {

    //token 有效时长
    private long tokenEcpiration =24 * 60 * 60 *1000;

    //编码秘钥
    private String tokenSignKey="123456";

    //使用jwt根据用户名生成token
    public String createToken(String username){
        String token= Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+tokenEcpiration))
                .signWith(SignatureAlgorithm.HS512,tokenSignKey).compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    //根据token字符串的到用户信息
    public String getUserInfoFromToken(String token){
        return   Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token).getBody().getSubject();
    }

    //删除token
    public void removeToken(String token){
        //jwttoken无需删除，客户端删除即可
    }
}
