package com.example.containerback.loadcp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


public interface LoadcpRepository extends JpaRepository<Loadcp, Long> {
}
