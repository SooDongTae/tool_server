package tool.tool.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.user.domain.Participant;
import tool.tool.domain.user.domain.type.JoinStatus;
import tool.tool.domain.user.facade.ParticipantFacade;

@Service
@RequiredArgsConstructor
public class ApproveParticipantService {

    private final ParticipantFacade participantFacade;

    @Transactional
    public void execute(Long id) {
        Participant participant = participantFacade.findParticipantById(id);
        participant.updateJoinStatus(JoinStatus.APPROVED);
        participant.getGroupBuying().getUser().decreaseJoinRequests();
    }

}
