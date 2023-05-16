package tool.tool.domain.board.comment.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CommentListResponse {
    private List<CommentResponse> commentResponses;
}
