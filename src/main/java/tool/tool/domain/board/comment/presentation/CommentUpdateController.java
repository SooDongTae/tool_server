package tool.tool.domain.board.comment.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tool.tool.domain.board.comment.presentation.dto.request.CommentUpdateRequest;
import tool.tool.domain.board.comment.service.CommentUpdateService;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentUpdateController {

    private final CommentUpdateService commentUpdateService;

    @PutMapping("/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody CommentUpdateRequest request) {
        commentUpdateService.execute(id, request);
    }
}
