package tool.tool.domain.board.board.domain.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BoardCategory {

    FREE("free"),
    PARTY("party"),
    QUESTION("question");

    private final String category;
}
