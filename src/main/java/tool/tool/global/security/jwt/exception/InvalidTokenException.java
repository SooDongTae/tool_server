package tool.tool.global.security.jwt.exception;

import tool.tool.global.error.exception.ToolException;
import tool.tool.global.security.jwt.exception.error.JwtErrorProperty;

public class InvalidTokenException extends ToolException {

    public final static InvalidTokenException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException() {
        super(JwtErrorProperty.INVALID_TOKEN);
    }
}
