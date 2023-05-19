package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.repository.GroupBuyingRepository;
import tool.tool.domain.group_buying.presentation.dto.request.GroupBuyingCreateRequest;
import tool.tool.domain.image.service.ImageSaveService;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GroupBuyingCreateService {
    private final GroupBuyingRepository groupBuyingRepository;
    private final UserFacade userFacade;
    private final ImageSaveService imageService;

    @Transactional
    public Long execute(GroupBuyingCreateRequest request, MultipartFile file) throws IOException {
        User user = userFacade.findUserById(userFacade.getCurrentUser().getId());
        GroupBuying groupBuying = groupBuyingRepository.save(request.toEntity(user));
        String imgSrc = imageService.execute(file);
        groupBuying.updateImg(imgSrc);
        return groupBuying.getId();
    }
}
