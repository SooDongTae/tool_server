package tool.tool.domain.group_buying.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.repository.GroupBuyingRepository;
import tool.tool.domain.group_buying.presentation.dto.request.GroupBuyingCreateRequest;
import tool.tool.domain.user.domain.Leader;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.domain.repository.LeaderRepository;
import tool.tool.domain.user.domain.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class GroupBuyingFacade {
    private final GroupBuyingRepository groupBuyingRepository;
    private final UserRepository userRepository;

    @Transactional
    public GroupBuying saveGroupBuying(GroupBuyingCreateRequest request, Leader leader) {
        return groupBuyingRepository.save(
                GroupBuying.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .cost(request.getCost())
                        .leader(leader)
                        .untilAt(request.getUntilAt())
                        .build()
        );
    }

    @Transactional
    public GroupBuying findGroupBuyingById(Long id) {
        return groupBuyingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("group_buying not found"));
    }
}
