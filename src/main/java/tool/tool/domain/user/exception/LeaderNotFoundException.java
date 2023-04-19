package tool.tool.domain.user.exception;

import tool.tool.domain.user.exception.error.UserErrorProperty;
import tool.tool.global.error.exception.ErrorProperty;
import tool.tool.global.error.exception.ToolException;

public class LeaderNotFoundException extends ToolException {

    public final static LeaderNotFoundException EXCEPTION = new LeaderNotFoundException();

    public LeaderNotFoundException() {
        super(UserErrorProperty.LEADER_NOT_FOUND);
    }
}
