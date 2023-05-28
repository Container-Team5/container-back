package com.example.containerback.palette;

import com.example.containerback.palette.Palette;
import com.example.containerback.palette.PaletteRepository;
import com.example.containerback.palette.PaletteSaveRequestDto;
import com.example.containerback.palette.PaletteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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