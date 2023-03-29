package tool.tool.domain.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Participant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    protected Participant() {}

    @Builder
    public Participant(Long id, User user) {
        this.id = id;
        this.user = user;
    }

    public void setUser(User user) {
        if(this.user != null) {
            user.getParticipants().remove(this);
        }
        this.user = user;
        user.getParticipants().add(this);
    }
}
