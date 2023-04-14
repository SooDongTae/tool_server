package tool.tool.domain.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLeader is a Querydsl query type for Leader
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLeader extends EntityPathBase<Leader> {

    private static final long serialVersionUID = -1026372518L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLeader leader = new QLeader("leader");

    public final StringPath accountBank = createString("accountBank");

    public final StringPath accountNum = createString("accountNum");

    public final tool.tool.domain.group_buying.domain.QGroupBuying groupBuying;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QUser user;

    public QLeader(String variable) {
        this(Leader.class, forVariable(variable), INITS);
    }

    public QLeader(Path<? extends Leader> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLeader(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLeader(PathMetadata metadata, PathInits inits) {
        this(Leader.class, metadata, inits);
    }

    public QLeader(Class<? extends Leader> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.groupBuying = inits.isInitialized("groupBuying") ? new tool.tool.domain.group_buying.domain.QGroupBuying(forProperty("groupBuying"), inits.get("groupBuying")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

