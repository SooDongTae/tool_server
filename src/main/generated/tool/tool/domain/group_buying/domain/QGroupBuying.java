package tool.tool.domain.group_buying.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGroupBuying is a Querydsl query type for GroupBuying
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGroupBuying extends EntityPathBase<GroupBuying> {

    private static final long serialVersionUID = 851862297L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGroupBuying groupBuying = new QGroupBuying("groupBuying");

    public final tool.tool.global.entity.QBaseTimeEntity _super = new tool.tool.global.entity.QBaseTimeEntity(this);

    public final EnumPath<tool.tool.domain.group_buying.domain.type.Category> category = createEnum("category", tool.tool.domain.group_buying.domain.type.Category.class);

    public final StringPath content = createString("content");

    public final NumberPath<Integer> cost = createNumber("cost", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> currentPeople = createNumber("currentPeople", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgSrc = createString("imgSrc");

    public final tool.tool.domain.user.domain.QLeader leader;

    public final NumberPath<Integer> maxPeople = createNumber("maxPeople", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final ListPath<tool.tool.domain.user.domain.Participant, tool.tool.domain.user.domain.QParticipant> participants = this.<tool.tool.domain.user.domain.Participant, tool.tool.domain.user.domain.QParticipant>createList("participants", tool.tool.domain.user.domain.Participant.class, tool.tool.domain.user.domain.QParticipant.class, PathInits.DIRECT2);

    public final EnumPath<tool.tool.domain.group_buying.domain.type.Status> status = createEnum("status", tool.tool.domain.group_buying.domain.type.Status.class);

    public final StringPath title = createString("title");

    public final DateTimePath<java.time.LocalDateTime> untilAt = createDateTime("untilAt", java.time.LocalDateTime.class);

    public QGroupBuying(String variable) {
        this(GroupBuying.class, forVariable(variable), INITS);
    }

    public QGroupBuying(Path<? extends GroupBuying> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGroupBuying(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGroupBuying(PathMetadata metadata, PathInits inits) {
        this(GroupBuying.class, metadata, inits);
    }

    public QGroupBuying(Class<? extends GroupBuying> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.leader = inits.isInitialized("leader") ? new tool.tool.domain.user.domain.QLeader(forProperty("leader"), inits.get("leader")) : null;
    }

}

