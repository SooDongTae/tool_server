package tool.tool.domain.group_buying.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.presentation.dto.request.GroupBuyingCreateRequest;
import tool.tool.domain.group_buying.presentation.dto.request.GroupBuyingUpdateRequest;
import tool.tool.domain.group_buying.service.GroupBuyingCreateService;
import tool.tool.domain.group_buying.service.GroupBuyingUpdateService;

import java.io.IOException;

@RestController
@RequestMapping("/api/groupBuying")
@RequiredArgsConstructor
public class GroupBuyingCreateOrUpdateController {

    private final GroupBuyingCreateService groupBuyingCreateService;
    private final GroupBuyingUpdateService groupBuyingUpdateService;

    @PostMapping("/create")
    public void createGroupBuying(@RequestPart GroupBuyingCreateRequest request, @RequestPart MultipartFile file) throws IOException {
        groupBuyingCreateService.execute(request, file);
    }

    @PutMapping("/{id}")
    public void updateGroupBuying(@PathVariable Long id, @RequestPart GroupBuyingUpdateRequest request, @RequestPart(required = false) MultipartFile file) throws IOException {
        groupBuyingUpdateService.execute(id, request, file);
    }
}
