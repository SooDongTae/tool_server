package tool.tool.domain.question.presentaion.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.question.domain.Question;

@Builder
@Getter
public class QuestionResponse {
    private Long id;
    private String content;
    private Boolean isSecret;
    private String writerName;

    public static QuestionResponse of(Question question) {
        return QuestionResponse.builder()
                .id(question.getId())
                .content(question.getContent())
                .isSecret(question.getIsSecret())
                .writerName(question.getUser().getName())
                .build();
    }
}
