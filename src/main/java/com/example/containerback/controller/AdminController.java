package com.example.containerback.controller;

import com.example.containerback.admin.Admin;
import com.example.containerback.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/admin/login")
    public Admin create(@RequestBody final Admin params) {
        Admin admin = adminService.findBy(params);
        return admin;
    }
}
