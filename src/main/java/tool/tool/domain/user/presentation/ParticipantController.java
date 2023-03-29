package tool.tool.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.user.presentation.dto.request.JoinGroupBuyingRequest;
import tool.tool.domain.user.service.ParticipantJoinService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/participant")
public class ParticipantController {

    private final ParticipantJoinService participantJoinService;

    @PostMapping("/join")
    public void joinGroupBuying(@RequestBody JoinGroupBuyingRequest request) {
        participantJoinService.execute(request);
    }
}
