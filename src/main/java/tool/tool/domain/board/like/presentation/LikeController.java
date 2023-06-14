package tool.tool.domain.board.like.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tool.tool.domain.board.like.presentation.dto.response.LikeResponse;
import tool.tool.domain.board.like.service.LikeService;

@RestController
@RequestMapping("/api/board/like")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/{boardId}")
    public LikeResponse like(@PathVariable Long boardId) {
        return likeService.execute(boardId);
    }

}
