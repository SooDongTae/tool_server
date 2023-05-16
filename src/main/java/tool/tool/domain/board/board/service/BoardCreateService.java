package tool.tool.domain.board.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.board.board.domain.repository.BoardRepository;
import tool.tool.domain.board.board.presentation.dto.request.BoardCreateRequest;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class BoardCreateService {

    private final UserFacade userFacade;
    private final BoardRepository boardRepository;

    @Transactional
    public void execute(BoardCreateRequest request) {
        User user = userFacade.findUserById(userFacade.getCurrentUser().getId());
        boardRepository.save(request.toEntity(user));
    }

}
