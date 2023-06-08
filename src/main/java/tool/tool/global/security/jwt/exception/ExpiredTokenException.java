package tool.tool.global.security.jwt.exception;

import tool.tool.global.error.exception.ToolException;
import tool.tool.global.security.jwt.exception.error.JwtErrorProperty;

public class ExpiredTokenException extends ToolException {

    public final static ExpiredTokenException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException() {
        super(JwtErrorProperty.EXPIRED_TOKEN);
    }
}
