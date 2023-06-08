package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.repository.GroupBuyingRepository;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AutoExpireGroupBuyingService {

    private final GroupBuyingRepository groupBuyingRepository;
    private final GroupBuyingFacade groupBuyingFacade;

    @Scheduled(cron = "1 0 0 * * MON-SUN")
    @Transactional
    public void expireOutDatedGroupBuying() {
        List<GroupBuying> expiredGroupBuyingList = groupBuyingRepository.findAll().stream().filter(groupBuying -> groupBuying.getUntilAt().isBefore(LocalDateTime.now())).toList();
        groupBuyingFacade.expireGroupBuying(expiredGroupBuyingList);
    }
}
