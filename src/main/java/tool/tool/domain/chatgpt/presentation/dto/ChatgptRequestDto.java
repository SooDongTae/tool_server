package tool.tool.domain.chatgpt.presentation.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public record ChatgptRequestDto(
        String question
) {
}