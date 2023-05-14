package tool.tool.domain.board.board.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tool.tool.domain.board.board.domain.Board;

public interface BoardRepositoryCustom {
    Page<Board> findByCategoryAndTitleContaining(String category, String title, Pageable pageable);
}
