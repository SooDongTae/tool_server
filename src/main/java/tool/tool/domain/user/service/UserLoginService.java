package tool.tool.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.auth.presentation.dto.response.TokenResponseDto;
import tool.tool.domain.user.domain.User;
import tool.tool.global.security.jwt.JwtTokenProvider;

@Service
@Transactional
@RequiredArgsConstructor
public class UserLoginService {


    private final UserSaveOrUpdateService userSaveOrUpdateService;
    private final JwtTokenProvider jwtTokenProvider;
    public TokenResponseDto execute(String authCode) {
        User user = userSaveOrUpdateService.execute(authCode);
        return TokenResponseDto.builder()
                .accessToken(jwtTokenProvider.createAccessToken(user.getEmail()))
                .refreshToken(jwtTokenProvider.createRefreshToken(user.getEmail()))
                .expire_at(jwtTokenProvider.getExpiredAt())
                .build();
    }
}
