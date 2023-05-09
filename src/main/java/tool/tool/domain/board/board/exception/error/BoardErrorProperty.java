package tool.tool.domain.board.board.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tool.tool.global.error.exception.ErrorProperty;

@Getter
@RequiredArgsConstructor
public enum BoardErrorProperty implements ErrorProperty {

    BOARD_NOT_FOUND(404, "게시글을 찾을 수 없습니다.");

    private final int status;
    private final String message;
}
