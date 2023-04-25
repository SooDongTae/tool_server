package tool.tool.domain.group_buying.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.group_buying.presentation.dto.request.GroupBuyingCreateRequest;
import tool.tool.domain.image.service.ImageSaveService;
import tool.tool.domain.user.domain.Leader;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.LeaderFacade;
import tool.tool.domain.user.facade.UserFacade;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GroupBuyingCreateService {
    private final GroupBuyingFacade groupBuyingFacade;
    private final UserFacade userFacade;
    private final LeaderFacade leaderFacade;
    private final ImageSaveService imageService;

    @Transactional
    public void execute(GroupBuyingCreateRequest request, MultipartFile file) throws IOException {
        User user = userFacade.findUserById(request.getLeaderId());
        Leader leader = leaderFacade.saveLeader(user, request.getBank(), request.getAccount());
        GroupBuying groupBuying = groupBuyingFacade.saveGroupBuying(request, leader);
        String imgSrc = imageService.execute(file);
        groupBuying.updateImg(imgSrc);
        leader.setGroupBuying(groupBuying);
    }
}
