package com.example.containerback.palette;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PaletteController {
    private final PaletteService paletteService;
    private final PaletteRepository paletteRepository;

    @PostMapping("/palette")
    public Long save(@RequestBody final PaletteSaveRequestDto requestDto) {
        return paletteService.save(requestDto);
    }

    @GetMapping("/palette/{id}")
    public String read(@PathVariable Long id) {
        Optional<Palette> paletteOptional = paletteRepository.findById(id);
        paletteOptional.ifPresent(System.out::println);

        return "successfully executed";
    }
}