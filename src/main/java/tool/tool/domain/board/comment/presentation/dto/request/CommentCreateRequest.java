package tool.tool.domain.board.comment.presentation.dto.request;

import lombok.Getter;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.comment.domain.Comment;
import tool.tool.domain.user.domain.User;

@Getter
public class CommentCreateRequest {
    private String content;

    public Comment toEntity(Board board, User user) {
        return Comment.builder()
                .content(this.content)
                .board(board)
                .user(user)
                .build();
    }
}
