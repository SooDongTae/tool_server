package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.type.Status;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class CancelGroupBuyingService {

    private final GroupBuyingFacade groupBuyingFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id) {
        GroupBuying groupBuying = groupBuyingFacade.findGroupBuyingById(id);
        User currentUser = userFacade.getCurrentUser();
        userFacade.checkUser(currentUser, groupBuying.getUser());
        groupBuying.statusUpdate(Status.CANCELED);
    }
}
