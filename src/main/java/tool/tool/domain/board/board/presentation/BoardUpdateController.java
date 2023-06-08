package tool.tool.domain.board.board.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tool.tool.domain.board.board.presentation.dto.request.BoardUpdateRequest;
import tool.tool.domain.board.board.service.BoardUpdateService;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardUpdateController {

    private final BoardUpdateService boardUpdateService;

    @PutMapping("/update/{id}")
    public void updateBoard(@PathVariable Long id, @RequestBody BoardUpdateRequest request) {
        boardUpdateService.execute(id, request);
    }
}