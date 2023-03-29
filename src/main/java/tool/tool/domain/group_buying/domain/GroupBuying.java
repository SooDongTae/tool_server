package tool.tool.domain.group_buying.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import tool.tool.global.entity.BaseTimeEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "group_buying")
@Getter
public class GroupBuying extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_buying_id")
    private Long id;

    private String title;

    private String content;

    private int price;

    @Column(name = "img_src")
    private String imgSrc;

    private LocalDateTime untilAt;

    protected GroupBuying() {}

    @Builder
    public GroupBuying(Long id, String title, String content, int price, String imgSrc, LocalDateTime untilAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.price = price;
        this.imgSrc = imgSrc;
        this.untilAt = untilAt;
    }
}
