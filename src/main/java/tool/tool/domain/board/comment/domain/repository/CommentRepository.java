package tool.tool.domain.board.comment.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.board.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom {
}
