package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.repository.GroupBuyingRepository;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingListResponse;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingResponse;
import tool.tool.domain.user.domain.Participant;
import tool.tool.domain.user.domain.repository.ParticipantRepository;
import tool.tool.domain.user.domain.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupBuyingListService {

    private final GroupBuyingRepository groupBuyingRepository;
    private final UserRepository userRepository;
    private final ParticipantRepository participantRepository;

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
        return GroupBuyingListResponse.builder()
                .groupBuyingResponseList(
                groupBuyingList
                .stream().map(GroupBuyingResponse::of).collect(Collectors.toList()))
                .build();
    }
}
