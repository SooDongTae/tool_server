package tool.tool.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tool.tool.domain.auth.domain.RefreshToken;
import tool.tool.domain.auth.domain.Repository.RefreshTokenRepository;
import tool.tool.domain.auth.presentation.dto.response.AccessTokenResponse;
import tool.tool.global.security.jwt.exception.ExpiredTokenException;

@Service
@RequiredArgsConstructor
public class RefreshAccessTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public AccessTokenResponse execute(String token) {
        RefreshToken refreshToken = refreshTokenRepository.findById(token).
                orElseThrow(() -> ExpiredTokenException.EXCEPTION);

        return AccessTokenResponse.builder()
                .AccessToken(refreshToken.getEmail())
                .build();
    }
}
