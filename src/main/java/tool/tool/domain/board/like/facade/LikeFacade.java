package tool.tool.domain.board.like.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.like.domain.Like;
import tool.tool.domain.board.like.domain.repository.LikeRepository;
import tool.tool.domain.board.like.domain.type.LikeKinds;
import tool.tool.domain.user.domain.User;

@Component
@RequiredArgsConstructor
public class LikeFacade {

    private final LikeRepository likeRepository;

    @Transactional
    public Like saveLike(Board board, User user) {
        return likeRepository.save(Like.builder()
                .board(board)
                .user(user)
                .likeKinds(LikeKinds.valueOf("LIKE"))
                .build());

    }
}
