package tool.tool.domain.board.comment.domain.repository;

import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.comment.domain.Comment;

import java.util.List;

public interface CommentRepositoryCustom {
    List<Comment> findByBoard(Board board);
}
