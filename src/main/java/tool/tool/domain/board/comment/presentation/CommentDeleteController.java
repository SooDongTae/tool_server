package tool.tool.domain.board.comment.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.board.comment.service.CommentDeleteService;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentDeleteController {

    private final CommentDeleteService commentDeleteService;

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentDeleteService.execute(id);
    }
}
