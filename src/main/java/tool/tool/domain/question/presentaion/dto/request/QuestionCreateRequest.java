package tool.tool.domain.question.presentaion.dto.request;

import lombok.Getter;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.user.domain.User;

@Getter
public class QuestionCreateRequest {
    private String content;
    private boolean isSecret;

    public Question toEntity(GroupBuying groupBuying, User user) {
        return Question.builder()
                .content(this.content)
                .isSecret(this.isSecret)
                .groupBuying(groupBuying)
                .user(user)
                .build();
    }
}
