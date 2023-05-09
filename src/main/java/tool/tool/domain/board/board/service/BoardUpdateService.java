package tool.tool.domain.board.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.board.facade.BoardFacade;
import tool.tool.domain.board.board.presentation.dto.request.BoardUpdateRequest;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class BoardUpdateService {

    private final BoardFacade boardFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id, BoardUpdateRequest request) {
        Board board = boardFacade.findBoardById(id);
        User currentUser = userFacade.findUserById(userFacade.getCurrentUser().getId());
        userFacade.checkUser(currentUser, board.getUser());
        board.update(request);
    }

}
