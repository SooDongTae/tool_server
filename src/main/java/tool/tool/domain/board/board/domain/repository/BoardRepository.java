package tool.tool.domain.board.board.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.board.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
