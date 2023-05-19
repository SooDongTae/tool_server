package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.repository.GroupBuyingRepository;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingListResponse;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupBuyingListService {

    private final GroupBuyingRepository groupBuyingRepository;

    @Transactional
    public GroupBuyingListResponse execute(
            int size,
            int page,
            String sortField,
            String sortWay,
            String category,
            String title,
            String status
    ) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<GroupBuying> groupBuyingList = groupBuyingRepository.findGroupBuyingList(category, sortField, sortWay, title, status, pageable);
        return GroupBuyingListResponse.builder()
                .groupBuyingResponseList(
                groupBuyingList
                .stream().map(GroupBuyingResponse::of).collect(Collectors.toList()))
                .maxPage(groupBuyingList.getTotalPages())
                .build();
    }
}
