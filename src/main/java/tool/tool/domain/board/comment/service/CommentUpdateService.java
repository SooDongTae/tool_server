package tool.tool.domain.board.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.board.comment.domain.Comment;
import tool.tool.domain.board.comment.facade.CommentFacade;
import tool.tool.domain.board.comment.presentation.dto.request.CommentUpdateRequest;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class CommentUpdateService {

    private final CommentFacade commentFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id, CommentUpdateRequest request) {
        Comment comment = commentFacade.findById(id);
        User currentUser = userFacade.getCurrentUser();
        userFacade.checkUser(currentUser, comment.getUser());
        comment.update(request);
    }
}
