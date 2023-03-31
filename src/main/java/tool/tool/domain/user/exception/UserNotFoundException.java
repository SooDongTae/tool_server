package tool.tool.domain.user.exception;

import tool.tool.domain.user.exception.error.UserErrorProperty;
import tool.tool.global.error.exception.ToolException;

public class UserNotFoundException extends ToolException {

    public final static UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(UserErrorProperty.USER_NOT_FOUND);
    }
}
