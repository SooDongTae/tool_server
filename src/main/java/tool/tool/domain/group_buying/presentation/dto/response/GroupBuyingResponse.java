package tool.tool.domain.group_buying.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.group_buying.domain.GroupBuying;

@Getter
@Builder
public class GroupBuyingResponse {
    private Long id;
    private String title;
    private String content;
    private String owner;
    private String imgSrc;
    private int maxPeople;
    private int currentPeople;
    private int views;

    public static GroupBuyingResponse of(GroupBuying groupBuying) {
        return GroupBuyingResponse.builder()
                .id(groupBuying.getId())
                .title(groupBuying.getTitle())
                .content(groupBuying.getContent())
                .owner(groupBuying.getLeader().getUser().getName())
                .imgSrc(groupBuying.getImgSrc())
                .maxPeople(groupBuying.getMaxPeople())
                .currentPeople(groupBuying.getCurrentPeople())
                .views(groupBuying.getViews())
                .build();
    }

}
