package tool.tool.domain.answer.exception;

import tool.tool.domain.answer.exception.error.AnswerErrorProperty;
import tool.tool.global.error.exception.ToolException;

public class AnswerNotFound extends ToolException {

    public static final AnswerNotFound EXCEPTION = new AnswerNotFound();

    public AnswerNotFound() {
        super(AnswerErrorProperty.ANSWER_NOT_FOUND);
    }
}
