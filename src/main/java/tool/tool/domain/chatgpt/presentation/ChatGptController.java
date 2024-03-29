package tool.tool.domain.chatgpt.presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.chatgpt.presentation.dto.ChatgptRequestDto;
import tool.tool.domain.chatgpt.service.ChatGptService;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatGptController {

    private final ChatGptService chatGptService;

    @PostMapping()
    public String chatGptResponse(@RequestBody()ChatgptRequestDto request) throws JsonProcessingException {
        return chatGptService.getChatResponse(request.question());
    }
}
