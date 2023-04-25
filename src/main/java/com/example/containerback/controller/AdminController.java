package com.example.containerback.controller;

import com.example.containerback.domain.Admin;
import com.example.containerback.domain.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/admin")
    public Admin create(@RequestBody Admin admin) { return adminRepository.save(admin); }

    @GetMapping("/admin/{id}")
    public String read(@PathVariable Long id) {
        Optional<Admin> adminOptional = adminRepository.findById(id);
        adminOptional.ifPresent(System.out::println);

        return "successfully executed";
    }
}
