package com.example.containerback.user;

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

    private static final long serialVersionUID = -16112201L;

    public static final QUser user = new QUser("user");

    public final StringPath admCall = createString("admCall");

    public final StringPath adName = createString("adName");

    public final StringPath department = createString("department");

    public final StringPath facName = createString("facName");

    public final NumberPath<Long> IndexAdId = createNumber("IndexAdId", Long.class);

    public final StringPath location = createString("location");

    public final StringPath password = createString("password");

    public final StringPath position = createString("position");

    public final StringPath refreshToken = createString("refreshToken");

    public final StringPath rep = createString("rep");

    public final ListPath<UserRole, EnumPath<UserRole>> roles = this.<UserRole, EnumPath<UserRole>>createList("roles", UserRole.class, EnumPath.class, PathInits.DIRECT2);

    public final EnumPath<UserStatus> state = createEnum("state", UserStatus.class);

    public final StringPath userId = createString("userId");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

