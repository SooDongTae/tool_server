package tool.tool.domain.board.board.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = -886727850L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoard board = new QBoard("board");

    public final tool.tool.global.entity.QBaseTimeEntity _super = new tool.tool.global.entity.QBaseTimeEntity(this);

    public final EnumPath<tool.tool.domain.board.board.domain.category.BoardCategory> category = createEnum("category", tool.tool.domain.board.board.domain.category.BoardCategory.class);

    public final ListPath<tool.tool.domain.board.comment.domain.Comment, tool.tool.domain.board.comment.domain.QComment> comments = this.<tool.tool.domain.board.comment.domain.Comment, tool.tool.domain.board.comment.domain.QComment>createList("comments", tool.tool.domain.board.comment.domain.Comment.class, tool.tool.domain.board.comment.domain.QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<tool.tool.domain.board.like.domain.Like, tool.tool.domain.board.like.domain.QLike> likes = this.<tool.tool.domain.board.like.domain.Like, tool.tool.domain.board.like.domain.QLike>createList("likes", tool.tool.domain.board.like.domain.Like.class, tool.tool.domain.board.like.domain.QLike.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath title = createString("title");

    public final NumberPath<Integer> totalLikes = createNumber("totalLikes", Integer.class);

    public final tool.tool.domain.user.domain.QUser user;

    public final NumberPath<Integer> views = createNumber("views", Integer.class);

    public QBoard(String variable) {
        this(Board.class, forVariable(variable), INITS);
    }

    public QBoard(Path<? extends Board> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoard(PathMetadata metadata, PathInits inits) {
        this(Board.class, metadata, inits);
    }

    public QBoard(Class<? extends Board> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new tool.tool.domain.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

