package tool.tool.domain.board.board.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.board.board.presentation.dto.request.BoardCreateRequest;
import tool.tool.domain.board.board.service.BoardCreateService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardCreateController {

    private final BoardCreateService boardCreateService;

    @PostMapping()
    public Long createBoard(@RequestBody BoardCreateRequest request) {
        return boardCreateService.execute(request);
    }
}
