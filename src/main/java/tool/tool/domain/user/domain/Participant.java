package tool.tool.domain.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.global.entity.BaseTimeEntity;

@Entity
@Getter
public class Participant extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_buying_id")
    private GroupBuying groupBuying;

    protected Participant() {}

    @Builder
    public Participant(Long id, User user, GroupBuying groupBuying) {
        this.id = id;
        this.user = user;
        this.groupBuying = groupBuying;
    }
}
