package tool.tool.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.exception.PeopleMaxException;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.user.domain.Participant;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.exception.DifferentUserException;
import tool.tool.domain.user.exception.SameUserException;
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
        if(groupBuying.isMax()) throw PeopleMaxException.EXCEPTION;
        User leader = groupBuying.getUser();
        isSameUser(user, leader);
        participantFacade.saveParticipant(user, groupBuying);
        leader.increaseJoinRequests();
        groupBuying.increaseCurrentPeople();
    }

    private void isSameUser(User currentUser, User leader) {
        if(currentUser.getId().equals(leader.getId())) {
            throw SameUserException.EXCEPTION;
        }
    }
}
