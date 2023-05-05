package com.example.containerback.palette;

import com.example.containerback.palette.Palette;
import com.example.containerback.palette.PaletteRepository;
import com.example.containerback.user.User;
import com.example.containerback.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaletteService {

    private final PaletteRepository paletteRepository;

    public Palette registPalette(Palette palette) {
        return paletteRepository.save(palette);
    }
}
