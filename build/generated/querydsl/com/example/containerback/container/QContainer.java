package com.example.containerback.container;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QContainer is a Querydsl query type for Container
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QContainer extends EntityPathBase<Container> {

    private static final long serialVersionUID = -262776451L;

    public static final QContainer container = new QContainer("container");

    public final NumberPath<Long> containerId = createNumber("containerId", Long.class);

    public final SetPath<com.example.containerback.palette.Palette, com.example.containerback.palette.QPalette> containpalettes = this.<com.example.containerback.palette.Palette, com.example.containerback.palette.QPalette>createSet("containpalettes", com.example.containerback.palette.Palette.class, com.example.containerback.palette.QPalette.class, PathInits.DIRECT2);

    public final NumberPath<Float> height = createNumber("height", Float.class);

    public final NumberPath<Float> length = createNumber("length", Float.class);

    public final DateTimePath<java.time.LocalDateTime> releaseDate = createDateTime("releaseDate", java.time.LocalDateTime.class);

    public final NumberPath<Float> volume = createNumber("volume", Float.class);

    public final NumberPath<Float> weight = createNumber("weight", Float.class);

    public final NumberPath<Float> weightLimit = createNumber("weightLimit", Float.class);

    public final NumberPath<Float> width = createNumber("width", Float.class);

    public QContainer(String variable) {
        super(Container.class, forVariable(variable));
    }

    public QContainer(Path<? extends Container> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContainer(PathMetadata metadata) {
        super(Container.class, metadata);
    }

}

