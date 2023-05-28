package com.example.containerback.container;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ContainerService {

    private final ContainerRepository containerRepository;

    @Transactional
    public Long save(final ContainerSaveRequestDto requestDto) {
        return containerRepository.save(requestDto.toEntity()).getContainerId();
    }
}
