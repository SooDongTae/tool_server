package tool.tool.domain.board.board.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tool.tool.domain.board.board.presentation.dto.response.BoardDetailResponse;
import tool.tool.domain.board.board.presentation.dto.response.BoardListResponse;
import tool.tool.domain.board.board.service.BoardDetailService;
import tool.tool.domain.board.board.service.BoardListService;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardInfoController {

    private final BoardListService boardListService;
    private final BoardDetailService boardDetailService;

    @GetMapping("/list")
    public BoardListResponse list(
            @RequestParam int size,
            @RequestParam int page,
            @RequestParam String title,
            @RequestParam String category
    ) {
        return boardListService.execute(size, page, title, category);
    }

    @GetMapping("/{id}")
    public BoardDetailResponse detail(@PathVariable Long id) {
        return boardDetailService.execute(id);
    }

}
