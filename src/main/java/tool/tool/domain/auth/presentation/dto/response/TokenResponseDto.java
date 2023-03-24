package tool.tool.domain.auth.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class TokenResponseDto {
    private String accessToken;
    private String refreshToken;
    private LocalDateTime expire_at;

    protected TokenResponseDto() {}

    @Builder
    public TokenResponseDto(String accessToken, String refreshToken, LocalDateTime expire_at) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expire_at = expire_at;
    }
}
