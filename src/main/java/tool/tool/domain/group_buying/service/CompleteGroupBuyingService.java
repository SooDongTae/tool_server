package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class CompleteGroupBuyingService {

    private final GroupBuyingFacade groupBuyingFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id) {
        GroupBuying groupBuying = groupBuyingFacade.findGroupBuyingById(id);
        User currentUser = userFacade.findUserById(userFacade.getCurrentUser().getId());
        userFacade.checkUser(currentUser, groupBuying.getLeader().getUser());
        groupBuying.statusUpdate("completed");
        currentUser.increaseRatingScore();
    }
}