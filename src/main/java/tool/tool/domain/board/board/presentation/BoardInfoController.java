package tool.tool.domain.board.board.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.board.board.presentation.dto.response.BoardListResponse;
import tool.tool.domain.board.board.service.BoardListService;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardInfoController {

    private final BoardListService boardListService;

    @GetMapping("/list")
    public BoardListResponse list(
            @RequestParam int size,
            @RequestParam int page,
            @RequestParam String title,
            @RequestParam String category
    ) {
        return boardListService.execute(size, page, title, category);
    }

}
