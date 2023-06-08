package tool.tool.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.auth.domain.RefreshToken;
import tool.tool.domain.auth.domain.Repository.RefreshTokenRepository;

@Service
@RequiredArgsConstructor
public class UserLogoutService {
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void execute(String token) {
        refreshTokenRepository.findById(token)
                .ifPresent(refreshTokenRepository::delete);
        SecurityContextHolder.clearContext();
    }
}
