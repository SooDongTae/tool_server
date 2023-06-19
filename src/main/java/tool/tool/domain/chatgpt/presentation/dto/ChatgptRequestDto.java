package tool.tool.domain.chatgpt.presentation.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

//@Getter
//@Setter
//public class ChatgptRequestDto {
//    private String question;
//}

public record ChatgptRequestDto(
        String question
) {
}