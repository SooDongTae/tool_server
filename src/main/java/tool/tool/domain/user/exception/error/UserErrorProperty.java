package tool.tool.domain.user.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tool.tool.global.error.exception.ErrorProperty;

@Getter
@AllArgsConstructor
public enum UserErrorProperty implements ErrorProperty {

    USER_NOT_FOUND(404, "사용자가 없습니다."),
    LEADER_NOT_FOUND(404, "파티장이 없습니다.");

    private final int status;
    private final String message;
}
