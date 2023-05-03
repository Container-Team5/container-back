package com.example.containerback.controller;

import com.example.containerback.admin.Admin;
import com.example.containerback.admin.AdminRepository;
import com.example.containerback.admin.AdminService;
import com.example.containerback.form.AdminCreateForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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