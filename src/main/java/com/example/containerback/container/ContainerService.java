package com.example.containerback.container;

import com.example.containerback.palette.Palette;
import com.example.containerback.palette.PaletteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class ContainerService {

    private final ContainerRepository containerRepository;
    private final PaletteRepository paletteRepository;

    @Transactional
    public Long save(final ContainerSaveRequestDto requestDto) {
        return containerRepository.save(requestDto.toEntity()).getContainerId();
    }


}