package com.example.containerback.loadcp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoadcpController {
    private final LoadcpRepository loadcpRepository;
    private final LoadcpService loadcpService;

    @PostMapping("/loadcp")
    public Long save(@RequestBody final LoadcpSaveRequestDto requestDto) {
        return loadcpService.save(requestDto);
    }
}
