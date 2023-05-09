package tool.tool.domain.board.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.board.domain.repository.BoardRepository;
import tool.tool.domain.board.board.facade.BoardFacade;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class BoardDeleteService {

    private final BoardFacade boardFacade;
    private final UserFacade userFacade;
    private final BoardRepository boardRepository;

    @Transactional
    public void execute(Long id) {
        Board board = boardFacade.findBoardById(id);
        User currentUser = userFacade.getCurrentUser();
        userFacade.checkUser(currentUser, board.getUser());
        boardRepository.delete(board);
    }

}
