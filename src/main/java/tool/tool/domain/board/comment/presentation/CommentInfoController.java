package tool.tool.domain.board.comment.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.board.comment.presentation.dto.response.CommentListResponse;
import tool.tool.domain.board.comment.service.CommentListService;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentInfoController {

    private final CommentListService commentListService;

    @GetMapping("/{board_id}")
    public CommentListResponse getComments(@PathVariable Long board_id) {
        return commentListService.execute(board_id);
    }

}
