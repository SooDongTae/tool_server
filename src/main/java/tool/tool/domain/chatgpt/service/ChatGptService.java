package tool.tool.domain.chatgpt.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ChatGptService {

    private final ChatgptService chatgptService;

    @Value("${chatgpt.api-key}")
    private String apiKey;

    public String getChatResponse(String question) throws JsonProcessingException {
        if(question.equals(" ")) {
            return "안녕하세요, 공동구매 플랫폼 챗봇입니다:) 무엇을 도와드릴까요?";
        }
        WebClient webClient = WebClient.create();
        String requestBody = "{\"model\":\"gpt-3.5-turbo\",\"messages\":[{\"role\":\"system\",\"content\":\"너는 우리가 서비스 하고 있는 공동구매 플랫폼의 챗봇이야. 우리는 공동구매 플랫폼을 제공하고 있습니다. " +
                "로그인 후에, 공동구매 파티 생성이 가능합니다. " +
                "환불은 불가능 합니다. " +
                "결제는 사용자간의 송금으로 이루어집니다.\"},{\"role\":\"user\",\"content\":\"" + question + "\"}]}";
        String response = webClient.post()
                .uri("https://api.openai.com/v1/chat/completions")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(requestBody))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response);

        return jsonNode.get("choices").get(0).get("message").get("content").asText();

    }

}
