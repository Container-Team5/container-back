package com.example.containerback;

import com.example.containerback.admin.QAdmin;
import com.example.containerback.palette.PaletteSaveRequestDto;
import com.example.containerback.palette.QPalette;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.*;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public abstract class PaletteRepositoryUserImpl implements PaletteRepositoryUser{
    private final JPAQueryFactory query;

    @Override
    public List<Tuple> findByIndexAdIdWithPalette(Long IndexAdId, PaletteSaveRequestDto dto) {
        QPalette palette = QPalette.palette;
        QAdmin admin = QAdmin.admin;

        Long paletteId = dto.toEntity().getPaletteId(); // 팔레트 ID

        String paletteName = dto.getPName();  // 상품명

        int quantity = dto.getQuantity();  // 수량

        float height = dto.getHeight();  // 높이

        float weight = dto.getWeight();  // 무게

        LocalDateTime deadLine = dto.getDLine();  // 출고 마감 시간

        String firstDel = dto.getFirstDel();  // 1차 배송지

        String finalDel = dto.getFinalDel();

        List<Tuple> list = query.select(palette, admin.IndexAdId)
                .from(palette)
                .join(palette.admin, admin)
                .fetchJoin()
                .where(admin.IndexAdId.contains(paletteId))
                .offset()
    }

}
