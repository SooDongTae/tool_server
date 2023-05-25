package tool.tool.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.user.domain.Participant;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.domain.repository.ParticipantRepository;
import tool.tool.domain.user.domain.type.JoinStatus;

@Component
@RequiredArgsConstructor
public class ParticipantFacade {

    private final ParticipantRepository participantRepository;

    @Transactional
    public Participant saveParticipant(User user, GroupBuying groupBuying) {
        return participantRepository.save(Participant.builder()
                .groupBuying(groupBuying)
                .user(user)
                .joinStatus(JoinStatus.WAITING)
                .build());
    }
}
