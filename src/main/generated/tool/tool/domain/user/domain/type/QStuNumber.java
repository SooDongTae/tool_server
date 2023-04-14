package tool.tool.domain.user.domain.type;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStuNumber is a Querydsl query type for StuNumber
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QStuNumber extends BeanPath<StuNumber> {

    private static final long serialVersionUID = -915035398L;

    public static final QStuNumber stuNumber = new QStuNumber("stuNumber");

    public final NumberPath<Integer> ban = createNumber("ban", Integer.class);

    public final NumberPath<Integer> grade = createNumber("grade", Integer.class);

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    public QStuNumber(String variable) {
        super(StuNumber.class, forVariable(variable));
    }

    public QStuNumber(Path<? extends StuNumber> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStuNumber(PathMetadata metadata) {
        super(StuNumber.class, metadata);
    }

}

