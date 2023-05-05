package com.example.containerback.container;

import com.example.containerback.container.Container;
import com.example.containerback.container.ContainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContainerService {

    private final ContainerRepository containerRepository;

    public Container registContainer(Container container) {
        return containerRepository.save(container);
    }
}
