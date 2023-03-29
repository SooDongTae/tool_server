package tool.tool.domain.group_buying.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tool.tool.domain.group_buying.presentation.dto.request.GroupBuyingCreateRequest;
import tool.tool.domain.group_buying.service.GroupBuyingCreateService;

@RestController
@RequestMapping("/api/groupBuying")
@RequiredArgsConstructor
public class GroupBuyingCreateOrUpdateController {

    private final GroupBuyingCreateService groupBuyingCreateService;

    @PostMapping("/create")
    public void groupBuyingCreate(@RequestPart GroupBuyingCreateRequest request) {
        groupBuyingCreateService.execute(request);
    }
}
