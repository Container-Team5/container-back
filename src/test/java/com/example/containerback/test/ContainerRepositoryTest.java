package com.example.containerback.test;

import com.example.containerback.model.Container;
import com.example.containerback.model.ContainerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ContainerRepositoryTest {
    @Autowired
    ContainerRepository containerRepository;

    @Test
    public void InsertDummies() {

        IntStream.rangeClosed(1, 10).forEach(i -> {
            Container container = Container.builder()
                    .id(i)
                    /*컨테이너의 크기는 고정되어 있으니까 걍 지움*/
//                    .height(i)
//                    .width(i)
//                    .length(i)
//                    .volume(i)
                    .weight(i)
                    .weightlimit(i)
                    .deadline(Timestamp.valueOf("2023-04-11 22:34:00"))
                    .build();
            //Create!
            containerRepository.save(container);
        });
    }
    /*public void SelectDummies() {

        Long id = 10L;

        Optional<Container> result = containerRepository.findById(id);

        System.out.println("=============================");

        if(result.isPresent()) {
            Container container = result.get();
            System.out.println(container);
        }
    }*/
    public void UpdateDummies() {
        Container container = Container.builder()
                .id(10L)
                .weight(1)
                .weightlimit(2)
                .deadline(Timestamp.valueOf("2023-04-11 22:34:00"))
                .build();

        containerRepository.save(container);
    }
}
