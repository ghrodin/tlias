package com.ghrlearn.tlias;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void genJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "Tom");
        String jwt = Jwts.builder()
                .setClaims(claims) //自定义内容(载荷)
                .signWith(SignatureAlgorithm.HS256, "itheima") //签名算法
                .setExpiration(new Date(System.currentTimeMillis() +
                        24 * 3600 * 1000)) //有效期
                .compact();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(jwt);
    }

    @Test
    public void parseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")//指定签名密钥（必须保证和生成令牌时使用 相同的签名密钥）
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzIxNTQ1MTgxLCJ1c2VybmFtZSI6IlRvbSJ9.1_JpsFSEbe_AZ6p1H-UoOfq7Px-H0DGJmHTTS0S7OYU")
                                .getBody();
        System.out.println(claims);
    }

}
