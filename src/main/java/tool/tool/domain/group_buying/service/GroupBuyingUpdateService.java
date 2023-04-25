package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.group_buying.presentation.dto.request.GroupBuyingUpdateRequest;
import tool.tool.domain.image.service.ImageSaveService;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GroupBuyingUpdateService {

    private final GroupBuyingFacade groupBuyingFacade;
    private final ImageSaveService imageService;

    @Transactional
    public void execute(Long id, GroupBuyingUpdateRequest request, MultipartFile file) throws IOException {
        GroupBuying groupBuying = groupBuyingFacade.findGroupBuyingById(id);
        groupBuying.update(request);
        if(!file.isEmpty()) {
            String fileName = imageService.execute(file);
            groupBuying.updateImg(fileName);
        }
    }
}
