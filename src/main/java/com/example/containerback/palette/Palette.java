package com.example.containerback.palette;

import com.example.containerback.admin.Admin;
import com.example.containerback.container.Container;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Palette")
@Entity
public class Palette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    @Column(name="palette_Id")
    private Long paletteId; // 팔레트 ID

    @Column(name = "p_name", nullable = false)
    private String paletteName;  // 상품명

    @Column(length = 4, nullable = false)
    private int quantity;  // 수량

    @Column(length = 2, nullable = false)
    @ColumnDefault("1.1")
    private float width = 1.1F;  // 가로

    @Column(length = 2, nullable = false)
    @ColumnDefault("1.1")
    private float length = 1.1F;  // 세로

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

    @Column
    private Long containerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "index_ad_id")
    private Admin admin;


    @Builder
    public Palette(final String paletteName, final int quantity, final float height, final float volume, final float weight, final LocalDateTime deadLine, final String firstDel, final String finalDel, final Admin admin, final Long containerId){
        this.paletteName = paletteName;
        this.quantity = quantity;
        this.height = height;
        this.volume = this.height * 1.21F;
        this.weight = weight;
        this.deadLine = deadLine;
        this.firstDel = firstDel;
        this.finalDel = finalDel;
        this.admin = admin;
        this.containerId = containerId;
    }
}