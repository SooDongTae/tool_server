package tool.tool.domain.chatgpt.service;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatGptService {

    private final ChatgptService chatgptService;

    public String getChatResponse(String question) {
        return chatgptService.sendMessage("We serve a joint purchasing platform." +
                "After logging in, you can create a joint purchase party." +
                "Refund is not possible." +
                "Payment is made by the user to the account number entered at the time of party creation. " +
                question);
    }

}
