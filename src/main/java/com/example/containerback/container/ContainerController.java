package com.example.containerback.container;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ContainerController {
    private final ContainerService containerService;
    private final ContainerRepository containerRepository;

    @PostMapping("/container")
    public Long save(@RequestBody final ContainerSaveRequestDto requestDto) {
        return containerService.save(requestDto);
    }

    @GetMapping("/container/{id}")
    public String read(@PathVariable Long id) {
        Optional<Container> containerOptional = containerRepository.findById(id);
        containerOptional.ifPresent(System.out::println);

        return "successfully executed";
    }
}
