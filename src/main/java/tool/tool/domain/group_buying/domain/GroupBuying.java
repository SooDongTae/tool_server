package tool.tool.domain.group_buying.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.group_buying.presentation.dto.request.GroupBuyingUpdateRequest;
import org.hibernate.annotations.ColumnDefault;
import tool.tool.domain.group_buying.domain.type.Category;
import tool.tool.domain.group_buying.domain.type.Status;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.user.domain.Participant;
import tool.tool.domain.user.domain.User;
import tool.tool.global.entity.BaseTimeEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Column(name = "owner_account")
    private String ownerAccount;

    @Column(name = "owner_bank")
    private String ownerBank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "groupBuying")
    private List<Participant> participants;

    @OneToMany(mappedBy = "groupBuying")
    private List<Question> questions;

    protected GroupBuying() {}

    @Builder
    public GroupBuying(Long id, String title, String content, int cost, int maxPeople, int currentPeople, Category category, Status status, String imgSrc, LocalDateTime untilAt, int views, String ownerAccount, String ownerBank, User user, List<Participant> participants, List<Question> questions) {
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
        this.views = views;
        this.ownerAccount = ownerAccount;
        this.ownerBank = ownerBank;
        this.user = user;
        this.participants = participants;
        this.questions = questions;
    }
    
    public void update(GroupBuyingUpdateRequest request) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        this.title = request.getTitle();
        this.maxPeople = request.getMaxPeople();
        this.content = request.getContent();
        this.category = Category.valueOf(request.getCategory());
        this.cost = request.getCost();
        this.untilAt = LocalDateTime.parse(request.getUntilAt() + " 00:00:00.000", dateTimeFormatter);
    }
    
    public void increaseViews() {
        this.views++;
    }

    public void increaseCurrentPeople() {
        this.currentPeople++;
    }

    public void decreaseCurrentPeople() { this.currentPeople--; }

    public void updateImg(String fileName) {
        this.imgSrc = "https://tool-api.o-r.kr/api/image/" + fileName;
    }

    public void statusUpdate(Status status) {
        this.status = status;
    }
}