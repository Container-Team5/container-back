package com.example.containerback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/account", produces = MediaTypes.HAL_JSON_VALUE)
public class AdminController {

    /*@PostMapping("/Admin")
    public Admin registAdmin(@RequestBody Admin admin) {
        System.out.println(admin);
        return adminService.registAdmin(admin);
    }*/
}