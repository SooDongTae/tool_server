package tool.tool.domain.board.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tool.tool.domain.board.comment.domain.Comment;
import tool.tool.domain.board.comment.domain.repository.CommentRepository;
import tool.tool.domain.board.comment.facade.CommentFacade;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class CommentDeleteService {

    private final CommentFacade commentFacade;
    private final UserFacade userFacade;
    private final CommentRepository commentRepository;

    public void execute(Long id) {
        Comment comment = commentFacade.findById(id);
        User currentUser = userFacade.getCurrentUser();
        userFacade.checkUser(currentUser, comment.getUser());
        commentRepository.delete(comment);
    }
}
