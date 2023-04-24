package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.group_buying.presentation.dto.request.GroupBuyingUpdateRequest;

@Service
@RequiredArgsConstructor
public class GroupBuyingUpdateService {

    private final GroupBuyingFacade groupBuyingFacade;

    public void execute(Long id, GroupBuyingUpdateRequest request, MultipartFile file) {
        GroupBuying groupBuying = groupBuyingFacade.findGroupBuyingById(id);
        groupBuying.update(request);
        
    }
}
