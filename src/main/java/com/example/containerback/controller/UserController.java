package com.example.containerback.controller;
import com.example.containerback.user.User;
import com.example.containerback.user.UserRepository;
import com.example.containerback.user.UserService;
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
public class UserController {
    private UserService userService;

    @PostMapping("/user")
    public User registAdmin(@RequestBody User user) {
        System.out.println(user);
        return userService.registUser(user);
    }
}
