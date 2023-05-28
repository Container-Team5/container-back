package com.example.containerback.palette;

import com.example.containerback.palette.PaletteRepository;
import com.example.containerback.palette.PaletteSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PaletteService {

    private final PaletteRepository postsRepository;

    @Transactional
    public Long save(final PaletteSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getPId();}
}
