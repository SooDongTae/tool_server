package tool.tool.domain.chatgpt.service;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatGptService {

    private final ChatgptService chatgptService;

    public String getChatResponse(String question) {
        return chatgptService.sendMessage("우리는 공동구매 플랫폼을 제공하고 있습니다." +
                "\n" +
                "로그인 후에, 공동구매 파티 생성이 가능합니다." +
                "\n" +
                "환불은 불가능 합니다." +
                "\n" +
                "결제는 사용자간의 송금으로 이루어 집니다. " +
                "\n" +
                question +
                "\n" +
                "챗봇처럼 간단하게 답변해줘");
    }

}
