package tool.tool.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.repository.GroupBuyingRepository;
import tool.tool.domain.user.domain.Participant;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.domain.repository.ParticipantRepository;
import tool.tool.domain.user.facade.UserFacade;
import tool.tool.domain.user.presentation.dto.response.JoinRequestListResponse;
import tool.tool.domain.user.presentation.dto.response.JoinRequestResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JoinRequestsService {

    private final GroupBuyingRepository groupBuyingRepository;
    private final UserFacade userFacade;
    private final ParticipantRepository participantRepository;

    @Transactional
    public JoinRequestListResponse execute() {
        User user = userFacade.getCurrentUser();
        List<GroupBuying> groupBuyingList = groupBuyingRepository.findByUser(user);
        List<Participant> participantList = participantRepository.findIsWaitingInGroupBuying(groupBuyingList);
        return new JoinRequestListResponse(
                participantList.stream().map(JoinRequestResponse::of).collect(Collectors.toList())
        );
    }
}
