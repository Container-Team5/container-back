package com.example.containerback;

import com.example.containerback.palette.Palette;
import com.querydsl.jpa.impl.*;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.example.containerback.admin.QAdmin.admin;
import static com.example.containerback.palette.QPalette.palette;

public class PaletteCustomRepositoryImpl implements PaletteCustomRepository {
    private final JPAQueryFactory queryFactory;

    public PaletteCustomRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<Palette> findByIndexAdIdWithPalette(String userId) {
//        QPalette palette = QPalette.palette;
//        QAdmin admin = QAdmin.admin;
//
//        Long paletteId = dto.toEntity().getPaletteId(); // 팔레트 ID
//
//        String paletteName = dto.getPName();  // 상품명
//
//        int quantity = dto.getQuantity();  // 수량
//
//        float height = dto.getHeight();  // 높이
//
//        float weight = dto.getWeight();  // 무게
//
//        LocalDateTime deadLine = dto.getDLine();  // 출고 마감 시간
//
//        String firstDel = dto.getFirstDel();  // 1차 배송지
//
//        String finalDel = dto.getFinalDel();
//
//        List<Tuple> list = query.select(palette, admin.IndexAdId)
//                .from(palette)
//                .join(palette.admin, admin)
//                .fetchJoin()
//                .where(admin.IndexAdId.eq(paletteId))
//                .fetch();


        return queryFactory
                .select(palette)
                .from(palette)
                .join(palette.admin, admin)
                .where(admin.userId.eq(userId))
                .fetch();
    }

}
