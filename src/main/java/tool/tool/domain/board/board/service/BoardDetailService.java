package tool.tool.domain.board.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.board.facade.BoardFacade;
import tool.tool.domain.board.board.presentation.dto.response.BoardDetailResponse;
import tool.tool.domain.board.like.domain.Like;
import tool.tool.domain.board.like.domain.repository.LikeRepository;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardDetailService {

    private final BoardFacade boardFacade;
    private final UserFacade userFacade;
    private final LikeRepository likeRepository;

    @Transactional
    public BoardDetailResponse execute(Long id) {
        Board board = boardFacade.findBoardById(id);
        User currentUser = userFacade.getCurrentUser();
        userFacade.checkUser(currentUser, board.getUser());
        board.increaseViews();
        Optional<Like> like = likeRepository.findByBoardAndUser(board, currentUser);
        String myLike = like.isEmpty() ? "none" : like.get().getLikeKinds().getKind();
        return BoardDetailResponse.of(board, myLike);
    }
}
