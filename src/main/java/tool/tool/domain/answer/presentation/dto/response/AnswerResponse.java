package tool.tool.domain.answer.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.answer.domain.Answer;

import java.time.LocalDateTime;

@Getter
@Builder
public class AnswerResponse {
    private Long id;
    private String content;
    private String writerName;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;

    public static AnswerResponse of(Answer answer) {
        return AnswerResponse.builder()
                .id(answer.getId())
                .content(answer.getContent())
                .writerName(answer.getUser().getName())
                .createdAt(answer.getCreatedAt())
                .lastModifiedAt(answer.getModifiedAt())
                .build();
    }
}
