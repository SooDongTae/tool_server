package tool.tool.domain.auth.presentation.dto.request;

import lombok.Getter;

@Getter
public class RefreshTokenBodyRequest {
    private String refreshToken;
}
