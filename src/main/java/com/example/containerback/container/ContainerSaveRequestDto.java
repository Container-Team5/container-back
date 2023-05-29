package com.example.containerback.container;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ContainerSaveRequestDto {

    public float width;  // 가로(m)

    public float length;  // 세로(m)

    public float height;  // 높이(m)

    public float volume;  // 부피(m^3)

    public float weight;  // 무게(kg)

    public float weightLimit;  // 무게 제한(kg)

    public LocalDateTime releaseDate;  // 출고 마감 기한

    @Builder
    public ContainerSaveRequestDto(final float weight, final float weightLimit, final LocalDateTime releaseDate) {
        this.weight = weight;
        this.weightLimit = weightLimit;
        this.releaseDate = releaseDate;
    }

    public Container toEntity() {
        return Container.builder()
                .weight(weight)
                .weightLimit(weightLimit)
                .releaseDate(releaseDate)
                .build();
    }
}
