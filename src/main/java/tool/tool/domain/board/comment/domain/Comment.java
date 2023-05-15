package tool.tool.domain.board.comment.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.user.domain.User;
import tool.tool.global.entity.BaseTimeEntity;

@Entity
@Getter
public class Comment extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "comment_content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    protected Comment() {}

    @Builder
    public Comment(Long id, String content, Board board, User user) {
        this.id = id;
        this.content = content;
        this.board = board;
        this.user = user;
    }
}
