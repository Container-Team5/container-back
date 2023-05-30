package com.example.containerback.loadcp;

import com.example.containerback.container.Container;
import com.example.containerback.palette.Palette;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

@ToString
@DynamicInsert
@DynamicUpdate
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Loadcp")
@Entity
public class Loadcp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loadcpId;  // 컨테이너 ID

    @ManyToOne
    @JoinColumn(name = "containerId")
    private Container container;

    @ManyToOne
    @JoinColumn(name = "paletteId")
    private Palette palette;

    @Builder
    public Loadcp(final long containerId, final long paletteId) {
        this.container.setContainerId(containerId);
        this.palette.setPaletteId(paletteId);
    }
}
