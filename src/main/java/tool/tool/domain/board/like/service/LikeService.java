package tool.tool.domain.board.like.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.board.facade.BoardFacade;
import tool.tool.domain.board.like.domain.Like;
import tool.tool.domain.board.like.domain.repository.LikeRepository;
import tool.tool.domain.board.like.facade.LikeFacade;
import tool.tool.domain.board.like.presentation.dto.request.LikeRequest;
import tool.tool.domain.board.like.presentation.dto.response.LikeResponse;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final BoardFacade boardFacade;
    private final UserFacade userFacade;
    private final LikeRepository likeRepository;
    private final LikeFacade likeFacade;

    @Transactional
    public LikeResponse execute(Long boardId, LikeRequest request) {
        Board board = boardFacade.findBoardById(boardId);
        User user = userFacade.findUserById(userFacade.getCurrentUser().getId());
        Optional<Like> like_ = likeRepository.findByBoardAndUser(board, user);
        Like like;
        if(like_.isEmpty()) {
            like = likeFacade.saveLike(board, user, request.getKinds());
        } else {
            like = like_.get().update(request.getKinds());
        }
        return LikeResponse.of(like);
    }
}
