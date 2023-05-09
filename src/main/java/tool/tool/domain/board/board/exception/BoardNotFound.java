package tool.tool.domain.board.board.exception;

import tool.tool.domain.board.board.exception.error.BoardErrorProperty;
import tool.tool.global.error.exception.ToolException;

public class BoardNotFound extends ToolException {

    public static final BoardNotFound EXCEPTION = new BoardNotFound();

    public BoardNotFound() {
        super(BoardErrorProperty.BOARD_NOT_FOUND);
    }
}
