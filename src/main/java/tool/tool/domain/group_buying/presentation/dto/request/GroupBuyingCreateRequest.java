package tool.tool.domain.group_buying.presentation.dto.request;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GroupBuyingCreateRequest {
    private Long leaderId;
    private String title;
    private int maxPeople;
    private String content;
    private String untilAt;
    private String category;
    private int cost;
}
