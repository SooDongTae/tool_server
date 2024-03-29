package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.group_buying.presentation.dto.GroupBuyingRequest;
import tool.tool.domain.group_buying.presentation.dto.request.GroupBuyingUpdateRequest;
import tool.tool.domain.image.service.ImageSaveService;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GroupBuyingUpdateService {

    private final GroupBuyingFacade groupBuyingFacade;
    private final ImageSaveService imageService;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id, GroupBuyingRequest.GroupBuyingUpdateRequest request, MultipartFile file) throws IOException {
        GroupBuying groupBuying = groupBuyingFacade.findGroupBuyingById(id);
        User currentUser = userFacade.getCurrentUser();
        User writer = groupBuying.getUser();
        userFacade.checkUser(currentUser, writer);
        groupBuying.update(request);
        if(!file.isEmpty()) {
            String fileName = imageService.execute(file);
            groupBuying.updateImg(fileName);
        }
    }
}
