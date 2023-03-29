package tool.tool.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.user.domain.Participant;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.domain.repository.ParticipantRepository;

@Component
@RequiredArgsConstructor
public class ParticipantFacade {

    private final ParticipantRepository participantRepository;

    public Participant saveParticipant(User user, GroupBuying groupBuying) {
        Participant participant = new Participant();
        participant.setUser(user);
        participant.setGroupBuying(groupBuying);
        return participantRepository.save(participant);
    }
}
