package com.example.containerback.load;

import com.example.containerback.container.Container;
import com.example.containerback.palette.Palette;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Load")
@Entity
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    private Long lId;  // 적재 ID

    @ManyToOne()
    @JoinColumn(name = "cId")
    private Container container;  // 컨테이너 ID FK

    @ManyToOne()
    @JoinColumn(name = "pId")
    private Palette palette;  // 팔레트 ID FK

    @Column(nullable = false)
    private LocalDateTime dLine;  // 출고 마감 시간

    @Column(nullable = false)
    private String firstDel;  // 1차 배송지
}