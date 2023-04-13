package com.example.containerback.model;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.containerback.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
