package tool.tool.domain.board.board.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import tool.tool.domain.board.board.domain.category.BoardCategory;
import tool.tool.domain.board.board.presentation.dto.request.BoardUpdateRequest;
import tool.tool.domain.board.comment.domain.Comment;
import tool.tool.domain.board.like.domain.Like;
import tool.tool.domain.user.domain.User;
import tool.tool.global.entity.BaseTimeEntity;

import java.util.List;

@Entity
@Getter
public class Board extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(name = "board_title")
    private String title;

    @Column(name = "board_content")
    private String content;

    @Enumerated(EnumType.STRING)
    private BoardCategory category;

    @Column(name = "board_totalLikes")
    @ColumnDefault("0")
    private int totalLikes;

    @Column(name = "board_views")
    @ColumnDefault("0")
    private int views;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "board")
    private List<Like> likes;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments;

    protected Board() {}

    @Builder
    public Board(Long id, String title, String content, BoardCategory category, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.user = user;
    }

    public void update(BoardUpdateRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
        this.category = BoardCategory.valueOf(request.getCategory());
    }

    public void increaseViews() {
        this.views++;
    }

    public void updateTotalLikes(int likes) {this.totalLikes = likes;}

}
