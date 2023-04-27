package tool.tool.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.user.domain.Participant;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.ParticipantFacade;
import tool.tool.domain.user.facade.UserFacade;
import tool.tool.domain.user.presentation.dto.request.JoinGroupBuyingRequest;

@Service
@RequiredArgsConstructor
public class ParticipantJoinService {

    private final ParticipantFacade participantFacade;
    private final UserFacade userFacade;
    private final GroupBuyingFacade groupBuyingFacade;
    @Transactional
    public void execute(JoinGroupBuyingRequest request) {
        User user = userFacade.findUserById(userFacade.getCurrentUser().getId());
        GroupBuying groupBuying = groupBuyingFacade.findGroupBuyingById(request.getGroupBuyingId());
        participantFacade.saveParticipant(user, groupBuying);
        groupBuying.increaseCurrentPeople();
    }
}
