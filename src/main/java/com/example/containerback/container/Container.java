package com.example.containerback.container;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Container")
@Entity
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long containerId;  // 컨테이너 ID

    @Column(nullable = false)
    private float width;  // 가로(m)

    @Column(nullable = false)
    private float length;  // 세로(m)

    @Column(nullable = false)
    private float height;  // 높이(m)

    @Column
    private float volume;  // 부피(m^3)

    @Column(nullable = false)
    private float weight;  // 무게(kg)

    @Column(nullable = false)
    private float weightLimit;  // 무게 제한(kg)

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(nullable = false)
    private LocalDateTime releaseDate;  // 출고 마감 기한

    @Builder
    public Container(final float width, final float length, final float height, final float volume, final float weight, final float weightLimit, final LocalDateTime releaseDate) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.volume = this.height * this.length * this.width;
        this.weight = weight;
        this.weightLimit = weightLimit;
        this.releaseDate = releaseDate;
    }
}
