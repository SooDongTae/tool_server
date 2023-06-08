package tool.tool.domain.board.board.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.board.domain.category.BoardCategory;
import tool.tool.domain.board.board.domain.repository.BoardRepository;
import tool.tool.domain.board.board.exception.BoardNotFound;
import tool.tool.domain.board.board.presentation.dto.request.BoardCreateRequest;
import tool.tool.domain.user.domain.User;

@Component
@RequiredArgsConstructor
public class BoardFacade {

    private final BoardRepository boardRepository;

    @Transactional
    public Board findBoardById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> BoardNotFound.EXCEPTION);
    }

}
