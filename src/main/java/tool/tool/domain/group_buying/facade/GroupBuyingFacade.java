package tool.tool.domain.group_buying.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.repository.GroupBuyingRepository;
import tool.tool.domain.group_buying.domain.type.Category;
import tool.tool.domain.group_buying.domain.type.Status;
import tool.tool.domain.group_buying.exception.GroupBuyingNotFound;
import tool.tool.domain.group_buying.exception.PeopleMaxException;
import tool.tool.domain.group_buying.presentation.dto.request.GroupBuyingCreateRequest;
import tool.tool.domain.user.domain.Participant;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.domain.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GroupBuyingFacade {
    private final GroupBuyingRepository groupBuyingRepository;
    private final UserRepository userRepository;

    @Transactional
    public GroupBuying findGroupBuyingById(Long id) {
        return groupBuyingRepository.findById(id)
                .orElseThrow(() -> GroupBuyingNotFound.EXCEPTION);
    }

    public void canParticipate(GroupBuying groupBuying) {
        if(groupBuying.getCurrentPeople() >= groupBuying.getMaxPeople()) {
            throw PeopleMaxException.EXCEPTION;
        }
    }

    @Transactional
    public List<GroupBuying> getGroupBuyingByUser(User user) {
        return groupBuyingRepository.findGroupBuyingListByUser(user);
    }

    @Transactional
    public List<GroupBuying> getGroupBuyingByParticipant(List<Participant> participants) {
        return participants.stream().map(Participant::getGroupBuying).collect(Collectors.toList());
    }

    @Transactional
    public void expireGroupBuying(List<GroupBuying> groupBuyingList) {
        groupBuyingList.forEach(groupBuying -> {groupBuying.statusUpdate(Status.EXPIRED);});
    }

}
