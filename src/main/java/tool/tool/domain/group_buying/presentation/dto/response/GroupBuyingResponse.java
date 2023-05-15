package tool.tool.domain.group_buying.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.group_buying.domain.GroupBuying;

import java.time.LocalDateTime;

@Getter
@Builder
public class GroupBuyingResponse {
    private Long id;
    private String title;
    private String content;
    private int grade;
    private int class_no;
    private int student_no;
    private String owner;
    private String imgSrc;
    private int maxPeople;
    private int currentPeople;
    private int views;
    private int cost;
    private String status;
    private LocalDateTime untilAt;

    public static GroupBuyingResponse of(GroupBuying groupBuying) {
        return GroupBuyingResponse.builder()
                .id(groupBuying.getId())
                .title(groupBuying.getTitle())
                .content(groupBuying.getContent())
                .grade(groupBuying.getUser().getStuNumber().getGrade())
                .class_no(groupBuying.getUser().getStuNumber().getBan())
                .student_no(groupBuying.getUser().getStuNumber().getNum())
                .owner(groupBuying.getUser().getName())
                .imgSrc(groupBuying.getImgSrc())
                .maxPeople(groupBuying.getMaxPeople())
                .currentPeople(groupBuying.getCurrentPeople())
                .views(groupBuying.getViews())
                .cost(groupBuying.getCost())
                .status(groupBuying.getStatus().getName())
                .untilAt(groupBuying.getUntilAt())
                .build();
    }

}
