package com.example.containerback.palette;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPalette is a Querydsl query type for Palette
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPalette extends EntityPathBase<Palette> {

    private static final long serialVersionUID = 683667633L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPalette palette = new QPalette("palette");

    public final com.example.containerback.admin.QAdmin admin;

    public final SetPath<com.example.containerback.container.Container, com.example.containerback.container.QContainer> containerSet = this.<com.example.containerback.container.Container, com.example.containerback.container.QContainer>createSet("containerSet", com.example.containerback.container.Container.class, com.example.containerback.container.QContainer.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> deadLine = createDateTime("deadLine", java.time.LocalDateTime.class);

    public final StringPath finalDel = createString("finalDel");

    public final StringPath firstDel = createString("firstDel");

    public final NumberPath<Float> height = createNumber("height", Float.class);

    public final NumberPath<Float> length = createNumber("length", Float.class);

    public final NumberPath<Long> paletteId = createNumber("paletteId", Long.class);

    public final StringPath paletteName = createString("paletteName");

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final NumberPath<Float> volume = createNumber("volume", Float.class);

    public final NumberPath<Float> weight = createNumber("weight", Float.class);

    public final NumberPath<Float> width = createNumber("width", Float.class);

    public QPalette(String variable) {
        this(Palette.class, forVariable(variable), INITS);
    }

    public QPalette(Path<? extends Palette> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPalette(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPalette(PathMetadata metadata, PathInits inits) {
        this(Palette.class, metadata, inits);
    }

    public QPalette(Class<? extends Palette> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.admin = inits.isInitialized("admin") ? new com.example.containerback.admin.QAdmin(forProperty("admin")) : null;
    }

}

