package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingResponse;
import tool.tool.domain.user.domain.Participant;
import tool.tool.domain.user.domain.repository.ParticipantRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupBuyingDetailService {

    private final GroupBuyingFacade groupBuyingFacade;
    private final ParticipantRepository participantRepository;

    @Transactional
    public GroupBuyingResponse execute(Long id) {
        GroupBuying groupBuying = groupBuyingFacade.findGroupBuyingById(id);
        List<Participant> participants = participantRepository.findByGroupBuying(groupBuying);
        groupBuying.increaseViews();
        return GroupBuyingResponse.of(groupBuying, participants);
    }

}
