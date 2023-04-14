package tool.tool.domain.group_buying.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingListResponse;
import tool.tool.domain.group_buying.service.GroupBuyingListService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/groupBuying")
@RequiredArgsConstructor
public class GroupBuyingInfoController {

    private final GroupBuyingListService groupBuyingListService;

    @GetMapping("/list")
    public GroupBuyingListResponse getGroupBuyingList(
            @RequestParam int limit,
            @RequestParam int offset,
            @RequestParam String sortField,
            @RequestParam String sortWay,
            @RequestParam String category)
    {
        return groupBuyingListService.execute(limit, offset, sortField, sortWay, category);
    }
}
