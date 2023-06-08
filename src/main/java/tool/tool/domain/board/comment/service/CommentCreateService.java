package tool.tool.domain.board.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.board.facade.BoardFacade;
import tool.tool.domain.board.comment.domain.repository.CommentRepository;
import tool.tool.domain.board.comment.presentation.dto.request.CommentCreateRequest;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class CommentCreateService {

    private final BoardFacade boardFacade;
    private final UserFacade userFacade;
    private final CommentRepository commentRepository;

    @Transactional
    public void execute(Long board_id, CommentCreateRequest request) {
        Board board = boardFacade.findBoardById(board_id);
        User user = userFacade.findUserById(userFacade.getCurrentUser().getId());
        commentRepository.save(request.toEntity(board, user));
    }
}
