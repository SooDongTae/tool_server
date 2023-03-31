package tool.tool.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements ErrorProperty{
    INTERNAL_SERVER_ERROR(500, "서버 내부에 오류가 발생했습니다."),
    BAD_REQUEST(400, "잘못된 요청입니다.");

    private final int status;
    private final String message;
}
