package tool.tool.domain.user.domain;

import jakarta.persistence.*;
import leehj050211.bsmOauth.dto.resource.BsmUserResource;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import tool.tool.domain.answer.domain.Answer;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.user.domain.type.Authority;
import tool.tool.domain.user.domain.type.StuNumber;
import tool.tool.global.entity.BaseTimeEntity;

import java.util.List;

@Entity
@Getter
public class User extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Embedded
    private StuNumber stuNumber;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_rating")
    @ColumnDefault("5")
    private int rating;

    @Column(name = "rating_score")
    @ColumnDefault("0")
    private int ratingScore;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToMany(mappedBy = "user")
    private List<Leader> leaders;

    @OneToMany(mappedBy = "user")
    private List<Participant> participants;

    @OneToMany(mappedBy = "user")
    private List<Question> questions;

    @OneToMany(mappedBy = "user")
    private List<Answer> answerList;

    protected User() {}

    @Builder
    public User(Long id, String name, StuNumber stuNumber, String email, Authority authority) {
        this.id = id;
        this.name = name;
        this.stuNumber = stuNumber;
        this.email = email;
        this.authority = authority;
    }

    public User update(BsmUserResource resource) {
        this.email = resource.getEmail();
        this.name = resource.getStudent().getName();
        this.stuNumber = StuNumber.builder()
                .grade(resource.getStudent().getGrade())
                .ban(resource.getStudent().getClassNo())
                .num(resource.getStudent().getStudentNo())
                .build();
        return this;
    }

    public void decreaseRating() {
        this.rating--;
    }

    public void increaseRatingScore() {
        if(this.rating == 1) {
            return;
        }
        if(this.ratingScore + 1 == 3) {
            this.decreaseRating();
            this.ratingScore = 0;
        }
        else {
            this.ratingScore++;
        }
    }
}
