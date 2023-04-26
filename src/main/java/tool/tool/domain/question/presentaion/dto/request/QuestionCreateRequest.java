package tool.tool.domain.question.presentaion.dto.request;

import lombok.Getter;

@Getter
public class QuestionCreateRequest {
    private String content;
    private boolean isSecret;
}
