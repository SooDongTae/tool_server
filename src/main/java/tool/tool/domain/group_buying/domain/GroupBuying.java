package tool.tool.domain.group_buying.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.user.domain.Leader;
import tool.tool.domain.user.domain.Participant;
import tool.tool.domain.user.domain.User;
import tool.tool.global.entity.BaseTimeEntity;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "group_buying")
@Getter
public class GroupBuying extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_buying_id")
    private Long id;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    private int cost;

    @Column(name = "img_src")
    private String imgSrc;

    @Column(name = "until_at")
    private LocalDateTime untilAt;

    @OneToOne
    @JoinColumn(name = "leader_id")
    private Leader leader;

    @OneToMany(mappedBy = "groupBuying")
    private List<Participant> participants;

    protected GroupBuying() {}

    @Builder
    public GroupBuying(Long id, String title, String content, int cost, String imgSrc, LocalDateTime untilAt, Leader leader, List<Participant> participants) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.cost = cost;
        this.imgSrc = imgSrc;
        this.untilAt = untilAt;
        this.leader = leader;
        this.participants = participants;
    }
}