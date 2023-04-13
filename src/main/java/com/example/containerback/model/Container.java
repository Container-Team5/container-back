package com.example.containerback.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Container")
@Entity
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    private long id;  // 컨테이너 ID

//    @Column(length = 3, nullable = false)
//    private int width;  // 가로
//
//    @Column(length = 3, nullable = false)
//    private int length;  // 세로
//
//    @Column(length = 3, nullable = false)
//    private int height;  // 높이
//
//    @Column(length = 5, nullable = false)
//    private int volume;  // 부피

    @Column(length = 10, nullable = false)
    private int weight;  // 무게

    @Column(length = 10, nullable = false)
    private int weightlimit;  // 무게 제한

    @Column(length = 100, nullable = false)
    private Timestamp deadline;  // 출고 마감일
}
