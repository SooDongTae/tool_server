package tool.tool.domain.board.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.board.facade.BoardFacade;
import tool.tool.domain.board.comment.domain.Comment;
import tool.tool.domain.board.comment.domain.repository.CommentRepository;
import tool.tool.domain.board.comment.presentation.dto.response.CommentListResponse;
import tool.tool.domain.board.comment.presentation.dto.response.CommentResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentListService {

    private final BoardFacade boardFacade;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentListResponse execute(Long board_id) {
        Board board = boardFacade.findBoardById(board_id);
        List<Comment> comments = commentRepository.findByBoard(board);
        return new CommentListResponse(
                comments.stream().map(CommentResponse::of).collect(Collectors.toList())
        );
    }
}
