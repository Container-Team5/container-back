package com.example.containerback.test;

import com.example.containerback.model.Delivery;
import com.example.containerback.model.DeliveryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeliveryRepositoryTest {
    @Autowired
    DeliveryRepository deliveryRepository;

    @Test/*
    public void InsertDummies() {
        ArrayList<Integer> quantity = new ArrayList<>();
        Random random = new Random();
        IntStream.rangeClosed(0, 11).forEach(i -> {
            quantity.add(random.nextInt(10));
        });
        IntStream.rangeClosed(1, 8).forEach(i -> {
            Delivery delivery = Delivery.builder()
                    .orderId(Long.valueOf(i))
                    .pName("Product" + i)
                    .quantity(quantity.get(i))
                    .oName("Order" + i)
                    .orderDate(Timestamp.valueOf("2001-02-19 02:19:10"))
                    .deliveryDeadline(Timestamp.valueOf("2001-02-21 02:19:10"))
                    .firstDel("인천항")
                    .finalDel("경기도 수원시 장안구 경수대로 893")
                    .delState("배송 중")
                    .build();
            //Create!
            deliveryRepository.save(delivery);
        });
    }*/
    public void SelectDummies() {

        Long id = 10L;

        Optional<Delivery> result = deliveryRepository.findById(id);

        System.out.println("=============================");

        if(result.isPresent()) {
            Delivery delivery = result.get();
            System.out.println(delivery);
        }
    }
    /*public void UpdateDummies() {
        Delivery container = Container.builder()
                .id(10L)
                .weight(1)
                .weightlimit(2)
                .deadline(Timestamp.valueOf("2023-04-11 22:34:00"))
                .build();

        containerRepository.save(container);
    }*/
}