package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.repository.GroupBuyingRepository;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingListResponse;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingResponse;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.domain.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupBuyingListService {

    private final GroupBuyingRepository groupBuyingRepository;
    private final UserRepository userRepository;

    @Transactional
    public GroupBuyingListResponse execute(
            int limit,
            int offset,
            String sortField,
            String sortWay,
            String category,
            String title,
            String status
    ) {
        List<GroupBuying> groupBuyingList = groupBuyingRepository.findGroupBuyingList(category, limit, offset, sortField, sortWay, title, status);
        System.out.println("============================= n+1 시점 확인용 ==================================");
        return GroupBuyingListResponse.builder()
                .groupBuyingResponseList(
                groupBuyingList
                .stream().map(GroupBuyingResponse::of).collect(Collectors.toList()))
                .build();
    }
}
