package com.example.containerback.load;

import com.example.containerback.load.Load;
import com.example.containerback.load.LoadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoadService {

    private final LoadRepository loadRepository;

    public Load registLoad(Load load) {
        return loadRepository.save(load);
    }
}