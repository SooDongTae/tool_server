package tool.tool.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.user.domain.Participant;

@Getter
@Builder
public class JoinRequestResponse {
    private Long id;
    private String groupName;
    private int cost;
    private String userName;
    private int grade;
    private int classNo;
    private int studentNo;
    private String userProfile;

    public static JoinRequestResponse of(Participant participant) {
        return JoinRequestResponse.builder()
                .id(participant.getId())
                .groupName(participant.getGroupBuying().getContent())
                .cost(participant.getGroupBuying().getCost())
                .userName(participant.getUser().getName())
                .grade(participant.getUser().getStuNumber().getGrade())
                .classNo(participant.getUser().getStuNumber().getBan())
                .studentNo(participant.getUser().getStuNumber().getNum())
                .userProfile(participant.getUser().getProfileUrl())
                .build();
    }
}
