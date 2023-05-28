package com.example.containerback.palette;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
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

    @GetMapping("/palette")
    public List<Palette> searchPalette(
            @RequestParam(required = false) String pName,
            //localhost:8080/palette?pName=이름&dLineFrom=날짜&dLineTo=날짜
            @RequestParam(required = false) LocalDateTime dLineFrom,
            @RequestParam(required = false) LocalDateTime dLineTo
            ) {
        if (pName != null)
            return paletteRepository.findAllByPName(pName);
        if(dLineFrom != null && dLineTo != null)
            return paletteRepository.findAllByDLineGreaterThanEqualAndDLineLessThanEqual(dLineFrom, dLineTo);
        return paletteRepository.findAll();
    }
}