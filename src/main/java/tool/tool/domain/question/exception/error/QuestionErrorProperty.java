package tool.tool.domain.question.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tool.tool.global.error.exception.ErrorProperty;

@Getter
@RequiredArgsConstructor
public enum QuestionErrorProperty implements ErrorProperty {

    QUESTION_NOT_FOUND(404, "질문을 찾을 수 없습니다."),
    DIFFERENT_USER_EXCEPTION(403, "다른 유저 입니다.");

    private final int status;
    private final String message;
}
