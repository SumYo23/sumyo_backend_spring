package project.backend.domain.memberingredient.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberIngredient is a Querydsl query type for MemberIngredient
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberIngredient extends EntityPathBase<MemberIngredient> {

    private static final long serialVersionUID = -616321906L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberIngredient memberIngredient = new QMemberIngredient("memberIngredient");

    public final project.backend.domain.common.entity.QBaseEntity _super = new project.backend.domain.common.entity.QBaseEntity(this);

    public final NumberPath<Integer> cnt = createNumber("cnt", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final DateTimePath<java.time.LocalDateTime> expDt = createDateTime("expDt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final project.backend.domain.ingredient.entity.QIngredient ingredient;

    public final project.backend.domain.member.entity.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDate = _super.updatedDate;

    public QMemberIngredient(String variable) {
        this(MemberIngredient.class, forVariable(variable), INITS);
    }

    public QMemberIngredient(Path<? extends MemberIngredient> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberIngredient(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberIngredient(PathMetadata metadata, PathInits inits) {
        this(MemberIngredient.class, metadata, inits);
    }

    public QMemberIngredient(Class<? extends MemberIngredient> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ingredient = inits.isInitialized("ingredient") ? new project.backend.domain.ingredient.entity.QIngredient(forProperty("ingredient")) : null;
        this.member = inits.isInitialized("member") ? new project.backend.domain.member.entity.QMember(forProperty("member")) : null;
    }

}

