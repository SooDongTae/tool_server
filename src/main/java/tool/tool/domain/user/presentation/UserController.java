package tool.tool.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tool.tool.domain.user.presentation.dto.response.JoinRequestListResponse;
import tool.tool.domain.user.service.ApproveParticipantService;
import tool.tool.domain.user.service.JoinRequestsService;
import tool.tool.domain.user.service.RejectParticipantService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final JoinRequestsService joinRequestsService;
    private final ApproveParticipantService approveParticipantService;
    private final RejectParticipantService rejectParticipantService;

    @GetMapping("/joinRequests")
    public JoinRequestListResponse getJoinRequests() {
        return joinRequestsService.execute();
    }

    @PutMapping("/approve/{id}")
    public void approveParticipant(@PathVariable Long id) {
        approveParticipantService.execute(id);
    }

    @PutMapping("/reject/{id}")
    public void rejectParticipant(@PathVariable Long id) {
        rejectParticipantService.execute(id);
    }

}
