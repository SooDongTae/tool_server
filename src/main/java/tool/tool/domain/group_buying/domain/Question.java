package tool.tool.domain.group_buying.domain;

import jakarta.persistence.*;
import lombok.Getter;
import tool.tool.domain.user.domain.User;
import tool.tool.global.entity.BaseTimeEntity;

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

    public void setGroupBuying(GroupBuying groupBuying) {
        if(this.groupBuying != null) {
            this.groupBuying.getQuestions().remove(this);
        }
        this.groupBuying = groupBuying;
        groupBuying.getQuestions().add(this);
    }

    public void setUser(User user) {
        if(this.user != null) {
            this.user.getQuestions().remove(this);
        }
        this.user = user;
        user.getQuestions().add(this);
    }
}
