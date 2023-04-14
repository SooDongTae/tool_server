package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingResponse;

@Service
@RequiredArgsConstructor
public class GroupBuyingDetailService {

    private final GroupBuyingFacade groupBuyingFacade;

    @Transactional
    public GroupBuyingResponse execute(Long id) {
        return GroupBuyingResponse.of(groupBuyingFacade.findGroupBuyingById(id));
    }

}
