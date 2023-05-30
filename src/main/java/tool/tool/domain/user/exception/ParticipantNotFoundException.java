package tool.tool.domain.user.exception;

import tool.tool.domain.user.exception.error.UserErrorProperty;
import tool.tool.global.error.exception.ErrorProperty;
import tool.tool.global.error.exception.ToolException;

public class ParticipantNotFoundException extends ToolException {

    public final static ParticipantNotFoundException EXCEPTION = new ParticipantNotFoundException();

    public ParticipantNotFoundException() {
        super(UserErrorProperty.PARTICIPANT_NOT_FOUND);
    }
}
