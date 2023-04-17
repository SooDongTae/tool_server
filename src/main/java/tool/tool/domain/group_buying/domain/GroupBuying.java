package tool.tool.domain.group_buying.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import tool.tool.domain.group_buying.domain.type.Category;
import tool.tool.domain.group_buying.domain.type.Status;
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

    @Column(name = "max_people")
    private int maxPeople;

    @Column(name = "current_people")
    @ColumnDefault("0")
    private int currentPeople;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "img_src")
    private String imgSrc;

    @Column(name = "until_at")
    private LocalDateTime untilAt;

    @ColumnDefault("0")
    private int views;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id")
    private Leader leader;

    @OneToMany(mappedBy = "groupBuying")
    private List<Participant> participants;

    protected GroupBuying() {}

    @Builder
    public GroupBuying(Long id, String title, String content, int cost, int maxPeople, int currentPeople, Category category, Status status, String imgSrc, LocalDateTime untilAt, Leader leader, List<Participant> participants) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.currentPeople = currentPeople;
        this.category = category;
        this.status = status;
        this.imgSrc = imgSrc;
        this.untilAt = untilAt;
        this.leader = leader;
        this.participants = participants;
    }

    public void increaseViews() {
        this.views++;
    }
}