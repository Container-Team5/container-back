package com.example.containerback.palette;

import com.example.containerback.palette.Palette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PaletteRepository extends JpaRepository<Palette, Long> {
    List<Palette> findAllByPName(String pName);
    List<Palette> findAllByDLineGreaterThanEqualAndDLineLessThanEqual(LocalDateTime dLineFrom, LocalDateTime dLineTo);
}