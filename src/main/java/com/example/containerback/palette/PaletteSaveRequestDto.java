package com.example.containerback.palette;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PaletteSaveRequestDto {

    public String pName;  // 상품명
    public int quantity;  // 수량

    public float width;  // 가로

    public float length;  // 세로

    public float height;  // 높이

    public float volume;  // 부피

    public float weight;  // 무게

    public LocalDateTime dLine;  // 출고 마감 시간

    public String firstDel;  // 1차 배송지

    public String finalDel;  // 최종 배송지

    @Builder
    public PaletteSaveRequestDto(final String pName, final int quantity, final float height, final float weight, final LocalDateTime dLine, final String firstDel, final String finalDel){
        this.pName = pName;
        this.quantity = quantity;
        this.height = height;
        this.volume = this.length * 1.21F;
        this.weight = weight;
        this.dLine = dLine;
        this.firstDel = firstDel;
        this.finalDel = finalDel;
    }
    public Palette toEntity(){
        return Palette.builder()
                .paletteName(pName)
                .quantity(quantity)
                .height(height)
                .volume(volume)
                .weight(weight)
                .deadLine(dLine)
                .firstDel(firstDel)
                .finalDel(finalDel)
                .build();
    }
}