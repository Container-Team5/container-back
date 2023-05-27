package com.example.containerback.palette;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PaletteSaveRequestDto {

    private String pName;  // 상품명

    private int quantity;  // 수량

    private float width;  // 가로

    private float length;  // 세로

    private float height;  // 높이

    private float volume;  // 부피

    private float weight;  // 무게

    private LocalDateTime dLine;  // 출고 마감 시간

    private String firstDel;  // 1차 배송지

    private String finalDel;  // 최종 배송지

    @Builder
    public PaletteSaveRequestDto(final String pName,final int quantity,final float width,final float length,final float height,final float volume,final float weight,final LocalDateTime dLine,final String firstDel,final String finalDel){
        this.pName = pName;
        this.quantity = quantity;
        this.width = width;
        this.length = length;
        this.height = height;
        this.volume = volume;
        this.weight = weight;
        this.dLine = dLine;
        this.firstDel = firstDel;
        this.finalDel = finalDel;
    }
    public Palette toEntity(){
        return Palette.builder()
                .pName(pName)
                .quantity(quantity)
                .width(width)
                .length(length)
                .height(height)
                .volume(volume)
                .weight(weight)
                .dLine(dLine)
                .firstDel(firstDel)
                .finalDel(finalDel)
                .build();
    }
}

