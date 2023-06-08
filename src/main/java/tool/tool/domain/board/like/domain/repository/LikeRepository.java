package tool.tool.domain.board.like.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.like.domain.Like;
import tool.tool.domain.user.domain.User;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByBoardAndUser(Board board, User user);
}
