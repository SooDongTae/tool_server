package tool.tool.domain.board.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import tool.tool.domain.user.domain.User;

@Entity
@Getter
public class Board {

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

    public void setUser(User user) {
        if(this.user != null) {
            user.getBoardList().remove(this);
        }
        this.user = user;
        user.getBoardList().add(this);
    }
}
