package com.example.containerback.controller;

import com.example.containerback.admin.Admin;
import com.example.containerback.admin.AuthService;
import com.example.containerback.container.Container;
import com.example.containerback.request.RefreshRequest;
import com.example.containerback.request.SignInRequest;
import com.example.containerback.request.SignUpRequest;
import com.example.containerback.response.RefreshResponse;
import com.example.containerback.response.SignInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/account", produces = MediaTypes.HAL_JSON_VALUE)
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public SignInResponse signIn(
            @RequestBody SignInRequest signInRequest
    ) {
        return this.authService.signIn(signInRequest.getUserId(), signInRequest.getPassword());
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public SignInResponse signUp(
            @RequestBody SignUpRequest signUpRequest
    ) {
        return this.authService.signUp(signUpRequest);
    }

    @GetMapping("/checkid/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public String idCheck(
            @PathVariable String userId
    ) {
        this.authService.idCheck(userId);
        return "사용가능한 아이디입니다.";
    }

    @PostMapping("/refresh")
    @ResponseStatus(HttpStatus.OK)
    public RefreshResponse getNewAccessToken(
            @RequestBody RefreshRequest refreshRequest
    ) {
        return this.authService.refreshAccessToken(refreshRequest);
    }

    /*@PutMapping("/amdin/{IndexAdId}/palette/{paletteId}")
    public Admin orderPalettesToAdmin(
            @PathVariable Long IndexAdId,
            @PathVariable Long paletteId
    ){
        return authService.orderPalettesToAdmin(IndexAdId, paletteId);
    }*/
}