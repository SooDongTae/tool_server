package tool.tool.domain.user.exception;

import tool.tool.domain.question.exception.error.QuestionErrorProperty;
import tool.tool.domain.user.exception.error.UserErrorProperty;
import tool.tool.global.error.exception.ToolException;

public class DifferentUserException extends ToolException {

    public final static DifferentUserException EXCEPTION = new DifferentUserException();

    public DifferentUserException() {
        super(UserErrorProperty.DIFFERENT_USER_EXCEPTION);
    }
}
