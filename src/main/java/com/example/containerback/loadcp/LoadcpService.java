package com.example.containerback.loadcp;

import com.example.containerback.palette.PaletteRepository;
import com.example.containerback.palette.PaletteSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LoadcpService {
    private final LoadcpRepository loadcpRepository;

    @Transactional
    public Long save(final LoadcpSaveRequestDto requestDto) {
        return loadcpRepository.save(requestDto.toEntity()).getLoadcpId();}
}
