package tool.tool.domain.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParticipant is a Querydsl query type for Participant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QParticipant extends EntityPathBase<Participant> {

    private static final long serialVersionUID = 2141737602L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParticipant participant = new QParticipant("participant");

    public final tool.tool.global.entity.QBaseTimeEntity _super = new tool.tool.global.entity.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final tool.tool.domain.group_buying.domain.QGroupBuying groupBuying;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final QUser user;

    public QParticipant(String variable) {
        this(Participant.class, forVariable(variable), INITS);
    }

    public QParticipant(Path<? extends Participant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QParticipant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QParticipant(PathMetadata metadata, PathInits inits) {
        this(Participant.class, metadata, inits);
    }

    public QParticipant(Class<? extends Participant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.groupBuying = inits.isInitialized("groupBuying") ? new tool.tool.domain.group_buying.domain.QGroupBuying(forProperty("groupBuying"), inits.get("groupBuying")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

