package com.example.containerback.controller;

import com.example.containerback.admin.Admin;
import com.example.containerback.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AdminController {
    private AdminService adminService;

    @PostMapping("/Admin")
    public Admin registAdmin(@RequestBody Admin admin) {
        System.out.println(admin);
        return adminService.registAdmin(admin);
    }
}