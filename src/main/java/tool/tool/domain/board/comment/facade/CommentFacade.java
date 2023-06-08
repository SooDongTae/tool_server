package tool.tool.domain.board.comment.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.board.comment.domain.Comment;
import tool.tool.domain.board.comment.domain.repository.CommentRepository;
import tool.tool.domain.board.comment.exception.CommentNotFound;

@Component
@RequiredArgsConstructor
public class CommentFacade {

    private final CommentRepository commentRepository;

    @Transactional
    public Comment findById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> CommentNotFound.EXCEPTION);
    }
}
