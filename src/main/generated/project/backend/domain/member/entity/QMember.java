package project.backend.domain.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 975537420L;

    public static final QMember member = new QMember("member1");

    public final project.backend.domain.common.entity.QBaseEntity _super = new project.backend.domain.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<project.backend.domain.memberingredient.entity.MemberIngredient, project.backend.domain.memberingredient.entity.QMemberIngredient> memberIngredientList = this.<project.backend.domain.memberingredient.entity.MemberIngredient, project.backend.domain.memberingredient.entity.QMemberIngredient>createList("memberIngredientList", project.backend.domain.memberingredient.entity.MemberIngredient.class, project.backend.domain.memberingredient.entity.QMemberIngredient.class, PathInits.DIRECT2);

    public final StringPath refreshToken = createString("refreshToken");

    public final StringPath socialId = createString("socialId");

    public final EnumPath<SocialType> socialType = createEnum("socialType", SocialType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDate = _super.updatedDate;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

