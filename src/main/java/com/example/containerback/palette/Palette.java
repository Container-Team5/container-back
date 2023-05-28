package com.example.containerback.palette;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Palette")
@Entity
public class Palette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    private Long pId; // 팔레트 ID

    @Column(name = "p_name", nullable = false)
    private String paletteName;  // 상품명

    @Column(length = 4, nullable = false)
    private int quantity;  // 수량

    @Column(length = 2, nullable = false)
    private float width;  // 가로

    @Column(length = 2, nullable = false)
    private float length;  // 세로

    @Column(length = 2, nullable = false)
    private float height;  // 높이

    @Column
    private float volume;  // 부피

    @Column(length = 6, nullable = false)
    private float weight;  // 무게

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="d_line", nullable = false)
    private LocalDateTime deadLine;  // 출고 마감 시간

    @Column(nullable = false)
    private String firstDel;  // 1차 배송지

    @Column(nullable = false)
    private String finalDel;  // 최종 배송지

    @Builder
    public Palette(final String paletteName, final int quantity, final float width, final float length, final float height, final float volume, final float weight, final LocalDateTime deadLine, final String firstDel, final String finalDel){
        this.paletteName = paletteName;
        this.quantity = quantity;
        this.width = width;
        this.length = length;
        this.height = height;
        this.volume = this.height * this.length * this.width;
        this.weight = weight;
        this.deadLine = deadLine;
        this.firstDel = firstDel;
        this.finalDel = finalDel;
    }
}