package com.example.containerback;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    @Value("${jwt.secretKey}")
    private String secretKey;
    private Key key;
    private final long accessTokenValidMilSecond = 1000L * 60 * 10;
    private final long refreshTokenValidMilSecond = 1000L * 60 * 60 * 24 * 7;

    @PostConstruct
    protected void init() {
        this.key = Keys.hmacShaKeyFor(this.secretKey.getBytes());
    }

    @Bean
    public String createAccessToken(String adId) {
        return generateToken(adId, accessTokenValidMilSecond);
    }

    @Bean
    public String createRefreshToken(String adId) {
        return generateToken(adId, refreshTokenValidMilSecond);
    }

    protected String generateToken(String adId, long tokenValidMilSecond) {
        Date now = new Date();
        return Jwts.builder()
                .claim("adId",adId)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidMilSecond))
                .signWith(this.key, SignatureAlgorithm.HS256)
                .compact();
    }

    @Bean
    public Claims resolveToken(HttpServletRequest req) {
        String token = req.getHeader("Authorization");
        if (token == null)
            return null;
        else if (token.contains("Bearer"))
            token = token.replace("Bearer ", "");
        else
            throw new DecodingException("");

        return getClaimsFromToken(token);
    }

    public Claims getClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @Bean
    public Authentication getAuthentication(Claims claims) {
        return new UsernamePasswordAuthenticationToken(this.getAdId(claims), "", getAuthorities(claims));
    }

    public String getAdId(Claims claims) {
        return claims.getSubject();
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Claims claims) {
        List<String> adId = claims.get("adId", List.class);
        return adId.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
