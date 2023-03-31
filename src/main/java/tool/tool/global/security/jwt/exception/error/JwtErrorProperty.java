package tool.tool.global.security.jwt.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tool.tool.global.error.exception.ErrorProperty;

@Getter
@RequiredArgsConstructor
public enum JwtErrorProperty implements ErrorProperty {
    EXPIRED_TOKEN(401, "만료된 토큰입니다."),
    INVALID_TOKEN(401, "유효하지 않은 토큰입니다.");

    private final int status;
    private final String message;
}
