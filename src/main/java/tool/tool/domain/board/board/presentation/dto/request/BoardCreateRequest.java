package tool.tool.domain.board.board.presentation.dto.request;

import lombok.Getter;

@Getter
public class BoardCreateRequest {
    private String title;
    private String content;
    private String category;
}
