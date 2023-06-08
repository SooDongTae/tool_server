package tool.tool.domain.board.comment.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.comment.domain.Comment;

import java.util.List;

import static tool.tool.domain.board.comment.domain.QComment.comment;
import static tool.tool.domain.user.domain.QUser.user;

@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Comment> findByBoard(Board board) {
        return jpaQueryFactory
                .selectFrom(comment)
                .join(comment.user, user).fetchJoin()
                .where(
                        comment.board.eq(board)
                )
                .fetch();
    }
}
