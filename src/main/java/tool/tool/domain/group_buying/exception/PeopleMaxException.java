package tool.tool.domain.group_buying.exception;

import tool.tool.domain.group_buying.exception.error.GroupBuyingErrorProperty;
import tool.tool.global.error.exception.ToolException;

public class PeopleMaxException extends ToolException {

    public final static PeopleMaxException EXCEPTION = new PeopleMaxException();

    private PeopleMaxException() {
        super(GroupBuyingErrorProperty.PEOPLE_MAX);
    }

}
