package tool.tool.domain.board.board.presentation.dto.request;

import lombok.Getter;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.board.domain.category.BoardCategory;
import tool.tool.domain.user.domain.User;

@Getter
public class BoardCreateRequest {
    private String title;
    private String content;
    private String category;

    public Board toEntity(User user) {
        return Board.builder()
                .title(this.title)
                .content(this.content)
                .category(BoardCategory.valueOf(this.category))
                .user(user)
                .build();
    }
}
