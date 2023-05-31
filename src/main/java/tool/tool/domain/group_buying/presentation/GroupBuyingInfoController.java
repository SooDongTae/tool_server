package tool.tool.domain.group_buying.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingDetailResponse;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingListResponse;
import tool.tool.domain.group_buying.presentation.dto.response.GroupBuyingResponse;
import tool.tool.domain.group_buying.service.GroupBuyingDetailService;
import tool.tool.domain.group_buying.service.GroupBuyingListService;
import tool.tool.domain.group_buying.service.JoinedGroupBuyingListService;
import tool.tool.domain.group_buying.service.MyGroupBuyingListService;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/groupBuying")
@RequiredArgsConstructor
public class GroupBuyingInfoController {

    private final GroupBuyingListService groupBuyingListService;
    private final GroupBuyingDetailService groupBuyingDetailService;
    private final MyGroupBuyingListService myGroupBuyingListService;
    private final JoinedGroupBuyingListService joinedGroupBuyingListService;

    @GetMapping("/list")
    public GroupBuyingListResponse getGroupBuyingList(
            @RequestParam int size,
            @RequestParam int page,
            @RequestParam String sortField,
            @RequestParam String sortWay,
            @RequestParam String category,
            @RequestParam String title,
            @RequestParam String status)
    {
        return groupBuyingListService.execute(size, page, sortField, sortWay, category, title, status);
    }

    @GetMapping("/{id}")
    public GroupBuyingDetailResponse getGroupBuyingDetail(@PathVariable Long id) {
        return groupBuyingDetailService.execute(id);
    }

    @GetMapping("/myGroupBuying")
    public GroupBuyingListResponse getMyGroupBuying() {
        return myGroupBuyingListService.execute();
    }

    @GetMapping("/joinedGroupBuying")
    public GroupBuyingListResponse getJoinedGroupBuying() {
        return joinedGroupBuyingListService.execute();
    }

}
