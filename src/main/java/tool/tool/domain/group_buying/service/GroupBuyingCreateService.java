package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.repository.GroupBuyingRepository;
import tool.tool.domain.group_buying.presentation.dto.GroupBuyingRequest;
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

    @Transactional(rollbackFor = Exception.class)
    public Long execute(GroupBuyingRequest.GroupBuyingCreateRequest request, MultipartFile file) throws IOException {
        User user = userFacade.findUserById(userFacade.getCurrentUser().getId());
        GroupBuying groupBuying = groupBuyingRepository.save(request.toEntity(user));
        String imgSrc;
        try {
            imgSrc = imageService.execute(file);
        } catch (IOException e) {
            // 예외 발생 시 롤백이 되어야 하므로 다시 던져줍니다.
            throw e;
        };
        groupBuying.updateImg(imgSrc);
        return groupBuying.getId();
    }
}
