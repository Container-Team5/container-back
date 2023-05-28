package com.example.containerback.palette;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PaletteRepository extends JpaRepository<Palette, Long> {
    List<Palette> findAllByPaletteName(String pName);
    List<Palette> findAllByDeadLineGreaterThanEqualAndDeadLineLessThanEqual(LocalDateTime DeadLineFrom, LocalDateTime DeadLineTo);
}