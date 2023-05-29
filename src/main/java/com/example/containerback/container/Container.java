package com.example.containerback.container;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@ToString
@DynamicInsert
@DynamicUpdate
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
    @ColumnDefault("2.4")
    private float width = 2.4F;  // 가로(m)

    @Column(nullable = false)
    @ColumnDefault("5.9")
    private float length = 5.9F;  // 세로(m)

    @Column(nullable = false)
    @ColumnDefault("2.4")
    private float height = 2.4F;  // 높이(m)

    @Column
    @ColumnDefault("34.0")
    private float volume = 34.0F;  // 부피(m^3)

    @Column(nullable = false)
    private float weight;  // 무게(kg)

    @Column(nullable = false)
    private float weightLimit;  // 무게 제한(kg)

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(nullable = false)
    private LocalDateTime releaseDate;  // 출고 마감 기한

    @Builder
    public Container(final float weight, final float weightLimit, final LocalDateTime releaseDate) {
        this.weight = weight;
        this.weightLimit = weightLimit;
        this.releaseDate = releaseDate;
    }
}
