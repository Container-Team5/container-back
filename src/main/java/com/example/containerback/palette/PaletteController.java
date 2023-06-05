package com.example.containerback.palette;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public Long save(
            @RequestBody final PaletteSaveRequestDto requestDto
    ) {
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return paletteService.save(requestDto, userId);
    }

    @GetMapping("/palette/{id}")
    public String read(@PathVariable Long id) {
        Optional<Palette> paletteOptional = paletteRepository.findById(id);
        paletteOptional.ifPresent(System.out::println);

        return "successfully executed";
    }

    @GetMapping("/palette")
    public List<Palette> searchPalette(
            @RequestParam(required = false) Long paletteId,
            @RequestParam(required = false) String pName,
            //localhost:8080/palette?pName=이름&dLineFrom=날짜&dLineTo=날짜
            @RequestParam(required = false) LocalDateTime dLineFrom,
            @RequestParam(required = false) LocalDateTime dLineTo,
            @RequestParam(required = false) Long containerId
    ) {
        if(paletteId != null)
            return paletteRepository.findAllByPaletteId(paletteId);
        if (pName != null)
            return paletteRepository.findByPaletteNameContains(pName);
        if(dLineFrom != null && dLineTo != null)
            return paletteRepository.findAllByDeadLineGreaterThanEqualAndDeadLineLessThanEqual(dLineFrom, dLineTo);
        if(containerId != null)
            return paletteRepository.findAllByContainerId(containerId);
        return paletteRepository.findAll();
    }

    @PutMapping("/palette/{paletteId}/container/{containerId}")
    public Optional<Palette> UpdateContainerId(
            @RequestBody PaletteSaveRequestDto paletteSaveRequestDto,
            @PathVariable Long paletteId,
            @PathVariable Long containerId){
        Optional<Palette> updatePaletteContainer = paletteRepository.findById(paletteId);

        updatePaletteContainer.ifPresent(selectPalette -> {
            selectPalette.setContainerId(containerId);

            paletteRepository.save(selectPalette);
        });

        return updatePaletteContainer;
    }

//    @DeleteMapping("/delete/palette/{paletteId}")
//    public Optional<Palette> deleteContainerId(
//            @RequestBody PaletteSaveRequestDto paletteSaveRequestDto,
//            @PathVariable Long paletteId
//    ) {
//        Optional<Palette> deletePaletteContainer = paletteRepository.findById(paletteId);
//
//        deletePaletteContainer.ifPresent(deletetPalette ->{
//            deletetPalette.getContainerId();
//
//            paletteRepository.delete(deletetPalette);
//        });
//
//        return deletePaletteContainer;
//    }

}