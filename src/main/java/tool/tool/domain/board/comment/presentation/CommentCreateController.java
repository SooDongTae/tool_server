package tool.tool.domain.board.comment.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tool.tool.domain.board.comment.presentation.dto.request.CommentCreateRequest;
import tool.tool.domain.board.comment.service.CommentCreateService;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentCreateController {

    private final CommentCreateService commentCreateService;

    @PostMapping("/{board_id}")
    public void createComment(@PathVariable Long board_id, @RequestBody CommentCreateRequest request) {
        commentCreateService.execute(board_id, request);
    }
}

