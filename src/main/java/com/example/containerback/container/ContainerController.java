package com.example.containerback.container;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
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

    @GetMapping("/container")
    public List<Container> searchContainer(
            @RequestParam(required = false) String containerId,
            // localhost:8080/container?containerId=아이디&releaseDateFrom=날짜&releaseDateTo=날짜
            @RequestParam(required = false) LocalDateTime releaseDateFrom,
            @RequestParam(required = false) LocalDateTime releaseDateTo
    ) {
        if (containerId != null)
            return containerRepository.findAllByContainerId(Long.parseLong(containerId));
        if (releaseDateFrom != null && releaseDateTo != null)
            return containerRepository.findAllByReleaseDateGreaterThanEqualAndReleaseDateLessThanEqual(releaseDateFrom, releaseDateTo);
        return containerRepository.findAll();
    }

}
