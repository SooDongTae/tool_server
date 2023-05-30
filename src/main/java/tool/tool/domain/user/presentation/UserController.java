package tool.tool.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.user.presentation.dto.response.JoinRequestListResponse;
import tool.tool.domain.user.service.JoinRequestsService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final JoinRequestsService joinRequestsService;

    @GetMapping("/joinRequests")
    public JoinRequestListResponse getJoinRequests() {
        return joinRequestsService.execute();
    }

}
