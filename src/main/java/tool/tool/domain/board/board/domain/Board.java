package tool.tool.domain.board.board.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.board.board.presentation.dto.request.BoardUpdateRequest;
import tool.tool.domain.user.domain.User;
import tool.tool.global.entity.BaseTimeEntity;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    protected Board() {}

    public void setUser(User user) {
        if(this.user != null) {
            user.getBoardList().remove(this);
        }
        this.user = user;
        user.getBoardList().add(this);
    }

    @Builder
    public Board(Long id, String title, String content, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void update(BoardUpdateRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
