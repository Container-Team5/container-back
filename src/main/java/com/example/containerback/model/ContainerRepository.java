package com.example.containerback.model;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.containerback.model.Container;
public interface ContainerRepository extends JpaRepository<Container, Long> {

}
