package tool.tool.domain.board.board.domain.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.board.domain.category.BoardCategory;

import java.util.List;

import static tool.tool.domain.board.board.domain.QBoard.board;
import static tool.tool.domain.board.like.domain.QLike.like;
import static tool.tool.domain.user.domain.QUser.user;

@RequiredArgsConstructor
public class BoardRepositoryImpl {

    private final JPAQueryFactory jpaQueryFactory;

    public Page<Board> findByCategoryAndTitleContaining(String category, String title, Pageable pageable) {
        List<Board> boards = getBoards(category, title, pageable);

        Long count = getCount(category, title);
        return new PageImpl<>(boards, pageable, count);
    }

    private Long getCount(String category, String title) {
        return jpaQueryFactory
                .select(board.count())
                .from(board)
                .where(
                        categoryEq(category),
                        board.title.contains(title)
                )
                .fetchOne();
    }

    private List<Board> getBoards(String category, String title, Pageable pageable) {
        return jpaQueryFactory
                .selectFrom(board)
                .join(board.user, user).fetchJoin()
                .where(
                        categoryEq(category),
                        board.title.contains(title)
                )
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();
    }

    private BooleanExpression categoryEq(String category) {
        if(category.equals("all")) {
            return null;
        }
        return board.category.eq(BoardCategory.valueOf(category));
    }

}
