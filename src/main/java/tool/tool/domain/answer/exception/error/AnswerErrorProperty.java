package tool.tool.domain.answer.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tool.tool.global.error.exception.ErrorProperty;

@Getter
@RequiredArgsConstructor
public enum AnswerErrorProperty implements ErrorProperty {

    ANSWER_NOT_FOUND(404, "해당 질문이 없습니다.");

    private final int status;
    private final String message;
}
