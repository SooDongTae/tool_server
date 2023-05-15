package tool.tool.domain.group_buying.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.user.domain.Participant;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class GroupBuyingDetailResponse {
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
    private List<ParticipantResponse> participantResponses;

    public static GroupBuyingDetailResponse of(GroupBuying groupBuying, List<Participant> participants) {
        return GroupBuyingDetailResponse.builder()
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
                .participantResponses(participants.stream().map(ParticipantResponse::of).collect(Collectors.toList()))
                .build();
    }
}
