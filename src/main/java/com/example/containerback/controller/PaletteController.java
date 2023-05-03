package com.example.containerback.controller;

import com.example.containerback.palette.Palette;
import com.example.containerback.palette.PaletteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PaletteController {
    private PaletteRepository paletteRepository;

    @PostMapping("/palette")
    public Palette create(@RequestBody Palette palette) { return paletteRepository.save(palette); }

    @GetMapping("/palette/{id}")
    public String read(@PathVariable Long id) {
        Optional<Palette> paletteOptional = paletteRepository.findById(id);
        paletteOptional.ifPresent(System.out::println);

        return "successfully executed";
    }
}
