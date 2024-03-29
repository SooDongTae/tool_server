package tool.tool.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tool.tool.domain.auth.domain.RefreshToken;
import tool.tool.domain.auth.domain.Repository.RefreshTokenRepository;
import tool.tool.global.security.jwt.config.JwtProperties;
import tool.tool.global.security.jwt.exception.ExpiredTokenException;
import tool.tool.global.security.jwt.exception.InvalidTokenException;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;

    private Key getSecretKey(String key) {
        byte[] bytes = key.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(bytes);
    }

    public String createAccessToken(String email) {
        return createToken(email, jwtProperties.getAccessTime());
    }

    public String createRefreshToken(String email) {
        String refreshToken = createToken(email, jwtProperties.getRefreshTime());
        refreshTokenRepository.save(RefreshToken.builder()
                .token(refreshToken)
                .email(email)
                .build());
        return refreshToken;
    }


    public String createToken(String email, Long time) {
        Claims claims = Jwts.claims();
        claims.put("email", email);
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + time))
                .signWith(getSecretKey(jwtProperties.getSecretKey()), SignatureAlgorithm.HS256)
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(jwtProperties.getHeader());
        return parseToken(bearer);
    }

    private String parseToken(String bearerToken) {
        if(bearerToken != null && bearerToken.startsWith(jwtProperties.getPrefix())) {
            return bearerToken.replace(jwtProperties.getPrefix(), "");
        }
        return null;
    }

    public String getEmail(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSecretKey(jwtProperties.getSecretKey()))
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .get("email", String.class);
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    public LocalDateTime getExpiredAt() {
        return LocalDateTime.now().plusSeconds(jwtProperties.getRefreshTime() / 1000);
    }
}
