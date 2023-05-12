package tool.tool.domain.board.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.board.domain.repository.BoardRepository;
import tool.tool.domain.board.board.presentation.dto.response.BoardListResponse;

@Service
@RequiredArgsConstructor
public class BoardListService {

    private final BoardRepository boardRepository;

    public BoardListResponse execute(int size, int page, String title, String category) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Board> boards;
        if(category.equals("all")) {
            boards = boardRepository.findByTitleContaining(title, pageable);
        } else {
            boards = boardRepository.findByCategoryAndTitleContaining(category, title, pageable);
        }
        return BoardListResponse.of(boards);
    }
}
