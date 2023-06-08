package tool.tool.domain.question.presentaion.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.question.domain.Question;

import java.time.LocalDateTime;

@Builder
@Getter
public class QuestionResponse {
    private Long id;
    private String content;
    private Boolean isSecret;
    private String writerName;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;

    public static QuestionResponse of(Question question) {
        return QuestionResponse.builder()
                .id(question.getId())
                .content(question.getContent())
                .isSecret(question.getIsSecret())
                .writerName(question.getUser().getName())
                .createdAt(question.getCreatedAt())
                .lastModifiedAt(question.getModifiedAt())
                .build();
    }
}
