package tool.tool.domain.board.like.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.like.domain.type.LikeKinds;
import tool.tool.domain.user.domain.User;

@Entity
@Getter
public class Like {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likes_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private LikeKinds likeKinds;

    protected Like() {}

    @Builder
    public Like(Long id, Board board, User user, LikeKinds likeKinds) {
        this.id = id;
        this.setBoard(board);
        this.setUser(user);
        this.likeKinds = likeKinds;
    }

    public void setBoard(Board board) {
        if(this.board != null) {
            board.getLikes().remove(this);
        }
        this.board = board;
        board.getLikes().add(this);
    }

    public void setUser(User user) {
        if(this.user != null) {
            user.getLikes().remove(this);
        }
        this.user = user;
        user.getLikes().add(this);
    }

    public Like update(String kinds) {
        this.likeKinds = LikeKinds.valueOf(kinds);
        return this;
    }
}
