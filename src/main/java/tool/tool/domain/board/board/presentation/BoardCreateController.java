package tool.tool.domain.board.board.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.board.board.presentation.dto.request.BoardCreateRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardCreateController {

    @PostMapping()
    public void createBoard(@RequestBody BoardCreateRequest request) {

    }
}
