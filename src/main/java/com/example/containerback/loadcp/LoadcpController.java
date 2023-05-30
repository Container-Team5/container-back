package com.example.containerback.loadcp;

import com.example.containerback.palette.PaletteRepository;
import com.example.containerback.palette.PaletteSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoadcpController {
    private final LoadcpRepository loadcpRepository;

    @PostMapping("/loadcp")
    public Long save(@RequestBody final LoadcpSaveRequestDto requestDto) {
        return LoadcpService.save(requestDto);
    }
}
