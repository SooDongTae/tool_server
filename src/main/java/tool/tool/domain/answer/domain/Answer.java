package tool.tool.domain.answer.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.user.domain.User;
import tool.tool.global.entity.BaseTimeEntity;

@Entity
@Getter
public class Answer extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long id;

    @Column(name = "answer_content", columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    protected Answer() {}

    @Builder
    public Answer(Long id, String content, Question question, User user) {
        this.id = id;
        this.content = content;
        this.question = question;
        this.user = user;
    }

    public void setQuestion(Question question) {
        if(this.question != null) {
            question.getAnswerList().remove(this);
        }
        this.question = question;
        question.getAnswerList().add(this);
    }

    public void setUser(User user) {
        if(this.user != null) {
            user.getAnswerList().remove(this);
        }
        this.user = user;
        user.getAnswerList().add(this);
    }
}
