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


    public void setUser(User user) {
        if(this.user != null) {
            user.getParticipants().remove(this);
        }
        this.user = user;
        user.getParticipants().add(this);
    }

    public void setGroupBuying(GroupBuying groupBuying) {
        if(this.groupBuying != null) {
            groupBuying.getParticipants().remove(this);
        }
        this.groupBuying = groupBuying;
        groupBuying.getParticipants().add(this);
    }
}
