package tool.tool.domain.answer.presentation.dto.request;

import lombok.Getter;
import tool.tool.domain.answer.domain.Answer;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.user.domain.User;

@Getter
public class AnswerCreateRequest {
    private String content;

    public Answer toEntity(Question question, User user) {
        return Answer.builder()
                .content(this.content)
                .question(question)
                .user(user)
                .build();
    }
}
