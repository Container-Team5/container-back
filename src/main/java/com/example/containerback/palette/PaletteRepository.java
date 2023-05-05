package com.example.containerback.palette;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PaletteRepository extends JpaRepository<Palette, Long> {

}