package tool.tool.domain.group_buying.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.user.domain.Participant;

@Getter
@Builder
public class ParticipantResponse {
    private int grade;
    private int ban;
    private int num;
    private String name;

    public static ParticipantResponse of(Participant participant) {
        return ParticipantResponse.builder()
                .grade(participant.getUser().getStuNumber().getGrade())
                .ban(participant.getUser().getStuNumber().getBan())
                .num(participant.getUser().getStuNumber().getNum())
                .name(participant.getUser().getName())
                .build();
    }
}
