package com.example.containerback.controller;

import com.example.containerback.container.Container;
import com.example.containerback.container.ContainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ContainerController {
    ContainerRepository containerRepository;

    @PostMapping("/container")
    public Container create(@RequestBody CreateContainerRequest request) { return containerRepository.save(new Container(request)); }

    @GetMapping("/container/{id}")
    public String read(@PathVariable Long id) {
        Optional<Container> containerOptional = containerRepository.findById(id);
        containerOptional.ifPresent(System.out::println);

        return "successfully executed";
    }
}
