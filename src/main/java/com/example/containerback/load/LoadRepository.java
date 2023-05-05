package com.example.containerback.load;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LoadRepository extends JpaRepository<Load, Long> {
}
