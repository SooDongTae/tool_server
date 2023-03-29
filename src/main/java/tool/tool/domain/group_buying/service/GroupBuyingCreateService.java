package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.group_buying.presentation.dto.request.GroupBuyingCreateRequest;
import tool.tool.domain.user.domain.Leader;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.domain.repository.UserRepository;
import tool.tool.domain.user.facade.LeaderFacade;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class GroupBuyingCreateService {
    private final GroupBuyingFacade groupBuyingFacade;
    private final UserFacade userFacade;
    private final LeaderFacade leaderFacade;
    public void execute(GroupBuyingCreateRequest request) {
        User user = userFacade.findUserById(request.getLeaderId());
        Leader leader = leaderFacade.saveLeader(user);
        GroupBuying groupBuying = groupBuyingFacade.saveGroupBuying(request, leader);
        leader.setGroupBuying(groupBuying);
    }
}
