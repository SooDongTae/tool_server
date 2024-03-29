package tool.tool.domain.question.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.answer.domain.Answer;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.question.presentaion.dto.request.QuestionUpdateRequest;
import tool.tool.domain.user.domain.User;
import tool.tool.global.entity.BaseTimeEntity;

import java.util.List;

@Entity
@Getter
public class Question extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @Column(name = "question_content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "isSecretQuestion")
    private Boolean isSecret;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_buying_id")
    private GroupBuying groupBuying;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "question")
    private List<Answer> answerList;

    protected Question() {}

    @Builder
    public Question(Long id, String content, Boolean isSecret, GroupBuying groupBuying, User user) {
        this.id = id;
        this.content = content;
        this.isSecret = isSecret;
        this.groupBuying = groupBuying;
        this.user = user;
    }

    public void update(QuestionUpdateRequest request) {
        this.content = request.getContent();
    }
}
