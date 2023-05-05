package com.example.containerback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.example.containerback.controller", "com.example.containerback.admin"})
public class ContainerBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContainerBackApplication.class, args);
    }

}
