package tool.tool.domain.group_buying.presentation.dto.request;

import lombok.Getter;

@Getter
public class GroupBuyingUpdateRequest {
    private String title;
    private String content;
    private String untilAt;
    private int cost;
}
