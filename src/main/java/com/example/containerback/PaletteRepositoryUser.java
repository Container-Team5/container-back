package com.example.containerback;

import com.example.containerback.palette.PaletteSaveRequestDto;
import com.querydsl.core.Tuple;

import java.util.List;

public abstract class PaletteRepositoryUser {
    abstract List<Tuple> findByIndexAdIdWithPalette(Long IndexAdId, PaletteSaveRequestDto dto);
}
