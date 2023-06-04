package com.example.containerback.palette;

import com.example.containerback.PaletteCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaletteRepository extends JpaRepository<Palette, Long>, PaletteCustomRepository {
    List<Palette> findAllByPaletteId(Long paletteId);
    List<Palette> findByPaletteNameContains(String pName);
    List<Palette> findAllByDeadLineGreaterThanEqualAndDeadLineLessThanEqual(LocalDateTime DeadLineFrom, LocalDateTime DeadLineTo);
}