package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;

@Service
@RequiredArgsConstructor
public class UpdateStatusService {

    private final GroupBuyingFacade groupBuyingFacade;

    @Transactional
    public void execute(Long id, String status) {
        GroupBuying groupBuying = groupBuyingFacade.findGroupBuyingById(id);
        groupBuying.statusUpdate(status);
    }
}
