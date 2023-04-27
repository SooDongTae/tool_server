package tool.tool.domain.question.exception;

import tool.tool.domain.question.exception.error.QuestionErrorProperty;
import tool.tool.global.error.exception.ErrorProperty;
import tool.tool.global.error.exception.ToolException;

public class DifferentUserException extends ToolException {

    public final static DifferentUserException EXCEPTION = new DifferentUserException();

    public DifferentUserException() {
        super(QuestionErrorProperty.DIFFERENT_USER_EXCEPTION);
    }
}
