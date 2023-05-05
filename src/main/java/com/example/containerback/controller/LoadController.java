package com.example.containerback.controller;

import com.example.containerback.container.Container;
import com.example.containerback.load.Load;
import com.example.containerback.load.LoadRepository;
import com.example.containerback.load.LoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoadController {
    LoadRepository loadRepository;

    @PostMapping("/load")
    public Load create(@RequestBody Load load) { return loadRepository.save(load); }

    @GetMapping("/load/{id}")
    public String read(@PathVariable Long id) {
        Optional<Load> loadOptional = loadRepository.findById(id);
        loadOptional.ifPresent(System.out::println);

        return "successfully executed";
    }
}