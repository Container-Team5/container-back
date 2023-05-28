package com.example.containerback.palette;

import com.example.containerback.admin.Admin;
import com.example.containerback.controller.CreatePaletteRequest;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Palette")
@Entity
public class Palette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    private Long pId; // 팔레트 ID

    @Column(length = 255, nullable = false)
    private String pName;  // 상품명

    @Column(length = 4, nullable = false)
    private int quantity;  // 수량
    @Column(length = 2, nullable = false)
    private float width;  // 가로

    @Column(length = 2, nullable = false)
    private float length;  // 세로

    @Column(length = 2, nullable = false)
    private float height;  // 높이

    @Column(length = 10, nullable = false)
    private float volume;  // 부피

    @Column(length = 6, nullable = false)
    private float weight;  // 무게

    @Column(nullable = false)
    private LocalDateTime dLine;  // 출고 마감 시간
    
    @Column(nullable = false)
    private String firstDel;  // 1차 배송지
    
    @Column(nullable = false)
    private String finalDel;  // 최종 배송지

    public Palette(CreatePaletteRequest request){
        this.pName = request.pName;
        this.quantity = request.quantity;
        this.width = request.width;
        this.length = request.length;
        this.height = request.height;
        this.volume = this.width * this.length * this.height;
        this.weight = request.weight;
        this.dLine = request.dline;
        this.firstDel = request.firstDel;
        this.finalDel = request.finalDel;
    }
}
