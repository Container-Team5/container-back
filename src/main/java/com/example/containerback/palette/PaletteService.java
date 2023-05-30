package com.example.containerback.palette;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PaletteService {

    private final PaletteRepository paletteRepository;

    @Transactional
    public Long save(final PaletteSaveRequestDto requestDto) {
        return paletteRepository.save(requestDto.toEntity()).getPaletteId();}
}