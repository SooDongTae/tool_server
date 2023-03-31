package tool.tool.domain.group_buying.exception;

import tool.tool.domain.group_buying.exception.error.GroupBuyingErrorProperty;
import tool.tool.global.error.exception.ToolException;

public class GroupBuyingNotFound extends ToolException {
    public final static GroupBuyingNotFound EXCEPTION = new GroupBuyingNotFound();

    private GroupBuyingNotFound(){
        super(GroupBuyingErrorProperty.GROUP_BUYING_NOT_FOUND);
    }
}
