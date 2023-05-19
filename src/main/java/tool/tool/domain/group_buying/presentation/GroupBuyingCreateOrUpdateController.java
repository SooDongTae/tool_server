package tool.tool.domain.group_buying.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tool.tool.domain.group_buying.presentation.dto.request.GroupBuyingCreateRequest;
import tool.tool.domain.group_buying.presentation.dto.request.GroupBuyingUpdateRequest;
import tool.tool.domain.group_buying.service.CancelGroupBuyingService;
import tool.tool.domain.group_buying.service.GroupBuyingCreateService;
import tool.tool.domain.group_buying.service.GroupBuyingUpdateService;
import tool.tool.domain.group_buying.service.CompleteGroupBuyingService;

import java.io.IOException;

@RestController
@RequestMapping("/api/groupBuying")
@RequiredArgsConstructor
public class GroupBuyingCreateOrUpdateController {

    private final GroupBuyingCreateService groupBuyingCreateService;
    private final GroupBuyingUpdateService groupBuyingUpdateService;
    private final CompleteGroupBuyingService completeGroupBuyingService;
    private final CancelGroupBuyingService cancelGroupBuyingService;

    @PostMapping("/create")
    public Long createGroupBuying(@RequestPart GroupBuyingCreateRequest request, @RequestPart MultipartFile file) throws IOException {
        return groupBuyingCreateService.execute(request, file);
    }

    @PutMapping("/{id}")
    public void updateGroupBuying(@PathVariable Long id, @RequestPart GroupBuyingUpdateRequest request, @RequestPart(required = false) MultipartFile file) throws IOException {
        groupBuyingUpdateService.execute(id, request, file);
    }

    @PutMapping("/complete/{id}")
    public void completeGroupBuying(@PathVariable Long id) {
        completeGroupBuyingService.execute(id);
    }

    @PutMapping("/cancel/{id}")
    public void cancelGroupBuying(@PathVariable Long id) {
        cancelGroupBuyingService.execute(id);
    }
}
