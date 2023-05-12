package tool.tool.domain.board.board.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.board.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Page<Board> findByCategoryAndTitleContaining(String category, String title, Pageable pageable);
    Page<Board> findByTitleContaining(String title, Pageable pageable);
}
