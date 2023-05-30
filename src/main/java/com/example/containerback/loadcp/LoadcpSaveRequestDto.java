package com.example.containerback.loadcp;

import com.example.containerback.palette.Palette;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class LoadcpSaveRequestDto {

    public Long containerId;
    public Long paletteId;

    @Builder
    public LoadcpSaveRequestDto(final long containerId, final long paletteId) {
        this.containerId = containerId;
        this.paletteId = paletteId;
    }
    public Loadcp toEntity() {
        return Loadcp.builder()
                .containerId(containerId)
                .paletteId(paletteId)
                .build();
    }
}
