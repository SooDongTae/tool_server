package tool.tool.domain.board.board.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.board.board.service.BoardDeleteService;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardDeleteController {

    private final BoardDeleteService boardDeleteService;

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardDeleteService.execute(id);
    }

}
