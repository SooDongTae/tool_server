package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import tool.tool.domain.group_buying.domain.repository.GroupBuyingRepository;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingListResponse;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingResponse;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupBuyingListService {

    private final GroupBuyingRepository groupBuyingRepository;

    @Transactional
    public GroupBuyingListResponse execute(
            int limit,
            int offset,
            String sortField,
            String sortWay,
            String category,
            String title
    ) {
        return GroupBuyingListResponse.builder()
                .groupBuyingResponseList(
                groupBuyingRepository.findGroupBuyingList(category, limit, offset, sortField, sortWay, title)
                .stream().map(GroupBuyingResponse::of).collect(Collectors.toList()))
                .build();
    }
}
