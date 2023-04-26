package tool.tool.domain.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1712516260L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final tool.tool.global.entity.QBaseTimeEntity _super = new tool.tool.global.entity.QBaseTimeEntity(this);

    public final EnumPath<tool.tool.domain.user.domain.type.Authority> authority = createEnum("authority", tool.tool.domain.user.domain.type.Authority.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Leader, QLeader> leaders = this.<Leader, QLeader>createList("leaders", Leader.class, QLeader.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final ListPath<Participant, QParticipant> participants = this.<Participant, QParticipant>createList("participants", Participant.class, QParticipant.class, PathInits.DIRECT2);

    public final ListPath<tool.tool.domain.question.domain.Question, tool.tool.domain.question.domain.QQuestion> questions = this.<tool.tool.domain.question.domain.Question, tool.tool.domain.question.domain.QQuestion>createList("questions", tool.tool.domain.question.domain.Question.class, tool.tool.domain.question.domain.QQuestion.class, PathInits.DIRECT2);

    public final tool.tool.domain.user.domain.type.QStuNumber stuNumber;

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.stuNumber = inits.isInitialized("stuNumber") ? new tool.tool.domain.user.domain.type.QStuNumber(forProperty("stuNumber")) : null;
    }

}

