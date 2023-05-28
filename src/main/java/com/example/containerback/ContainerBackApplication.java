package com.example.containerback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class ContainerBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContainerBackApplication.class, args);
    }

}