package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingListResponse;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingResponse;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyGroupBuyingListService {

    private final UserFacade userFacade;
    private final GroupBuyingFacade groupBuyingFacade;

    @Transactional
    public GroupBuyingListResponse execute() {
        User user = userFacade.findUserById(userFacade.getCurrentUser().getId());
        List<GroupBuying> groupBuyingList = groupBuyingFacade.getGroupBuyingByLeader(user.getLeaders());
        return GroupBuyingListResponse.builder()
                .groupBuyingResponseList(
                        groupBuyingList.stream()
                                .map(GroupBuyingResponse::of)
                                .collect(Collectors.toList()))
                .build();
    }
}
