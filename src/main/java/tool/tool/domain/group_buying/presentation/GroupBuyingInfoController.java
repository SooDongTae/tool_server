package tool.tool.domain.group_buying.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingListResponse;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingResponse;
import tool.tool.domain.group_buying.service.GroupBuyingDetailService;
import tool.tool.domain.group_buying.service.GroupBuyingListService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/groupBuying")
@RequiredArgsConstructor
public class GroupBuyingInfoController {

    private final GroupBuyingListService groupBuyingListService;
    private final GroupBuyingDetailService groupBuyingDetailService;

    @GetMapping("/list")
    public GroupBuyingListResponse getGroupBuyingList(
            @RequestParam int limit,
            @RequestParam int offset,
            @RequestParam String sortField,
            @RequestParam String sortWay,
            @RequestParam String category,
            @RequestParam String title,
            @RequestParam String status)
    {
        return groupBuyingListService.execute(limit, offset, sortField, sortWay, category, title, status);
    }

    @GetMapping("/{id}")
    public GroupBuyingResponse getGroupBuyingDetail(@PathVariable Long id) {
        return groupBuyingDetailService.execute(id);
    }

}
