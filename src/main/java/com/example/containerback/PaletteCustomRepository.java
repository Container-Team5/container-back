package com.example.containerback;

import com.example.containerback.palette.Palette;

import java.util.List;

public interface PaletteCustomRepository {
  public List<Palette> findByIndexAdIdWithPalette(String userId);
}