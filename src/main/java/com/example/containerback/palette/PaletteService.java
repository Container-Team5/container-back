package com.example.containerback.palette;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaletteService {

    private final PaletteRepository paletteRepository;

    public List<Palette> getPaletteDetails(Long paletteId) {
        if(null != paletteId) {
            return paletteRepository.findAllByPaletteId(paletteId);
        } else {
            return paletteRepository.findAll();
        }
    }

    @Transactional
    public Long save(final PaletteSaveRequestDto requestDto) {
        return paletteRepository.save(requestDto.toEntity()).getPaletteId();}
}