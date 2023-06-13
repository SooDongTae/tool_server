package tool.tool.domain.user.exception;

import tool.tool.domain.user.exception.error.UserErrorProperty;
import tool.tool.global.error.exception.ToolException;

public class SameUserException extends ToolException {

    public final static SameUserException EXCEPTION = new SameUserException();

    public SameUserException() {
        super(UserErrorProperty.SAME_USER_EXCEPTION);
    }
}
