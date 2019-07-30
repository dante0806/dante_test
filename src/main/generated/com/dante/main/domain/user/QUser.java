package com.dante.main.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -334129920L;

    public static final QUser user = new QUser("user");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final SetPath<UserRole, QUserRole> roles = this.<UserRole, QUserRole>createSet("roles", UserRole.class, QUserRole.class, PathInits.DIRECT2);

    public final StringPath use_yn = createString("use_yn");

    public final StringPath user_addr = createString("user_addr");

    public final StringPath user_nm = createString("user_nm");

    public final StringPath user_phone = createString("user_phone");

    public final StringPath user_zip = createString("user_zip");

    public final StringPath username = createString("username");

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

