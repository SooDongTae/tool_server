package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.repository.GroupBuyingRepository;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingListResponse;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingResponse;
import tool.tool.domain.user.domain.Leader;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.LeaderFacade;
import tool.tool.domain.user.facade.UserFacade;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyGroupBuyingListService {

    private final UserFacade userFacade;
    private final GroupBuyingRepository groupBuyingRepository;

    public GroupBuyingListResponse execute(Long id) {
        User user = userFacade.findUserById(id);
        List<GroupBuying> groupBuyingList = groupBuyingRepository.findGroupBuyingListByLeader(user.getLeaders());
        return GroupBuyingListResponse.builder()
                .groupBuyingResponseList(
                        groupBuyingList.stream()
                                .map(GroupBuyingResponse::of)
                                .collect(Collectors.toList()))
                .build();
    }
}
