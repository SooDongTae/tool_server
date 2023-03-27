package tool.tool.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tool.tool.domain.auth.domain.RefreshToken;
import tool.tool.domain.auth.domain.Repository.RefreshTokenRepository;
import tool.tool.domain.auth.presentation.dto.response.AccessTokenResponse;

@Service
@RequiredArgsConstructor
public class RefreshAccessTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public AccessTokenResponse execute(String token) {
        RefreshToken refreshToken = refreshTokenRepository.findById(token).
                orElseThrow(() -> new IllegalArgumentException("리프레쉬 토큰 만료"));

        return AccessTokenResponse.builder()
                .AccessToken(refreshToken.getEmail())
                .build();
    }
}
