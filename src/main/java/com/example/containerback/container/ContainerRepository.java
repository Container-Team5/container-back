package com.example.containerback.container;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

    List<Container> findAllByContainerId(Long containerId);
    List<Container> findAllByReleaseDateGreaterThanEqualAndReleaseDateLessThanEqual(LocalDateTime releaseDateFrom, LocalDateTime releaseDateTo);
}