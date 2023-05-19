package tool.tool.domain.group_buying.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GroupBuyingListResponse {
    private int maxPage;
    private List<GroupBuyingResponse> groupBuyingResponseList;
}
