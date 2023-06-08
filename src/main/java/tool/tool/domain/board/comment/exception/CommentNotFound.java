package tool.tool.domain.board.comment.exception;

import tool.tool.domain.board.comment.exception.error.CommentErrorProperty;
import tool.tool.global.error.exception.ToolException;

public class CommentNotFound extends ToolException {

    public static final CommentNotFound EXCEPTION = new CommentNotFound();

    public CommentNotFound() {
        super(CommentErrorProperty.COMMENT_NOT_FOUND);
    }
}
