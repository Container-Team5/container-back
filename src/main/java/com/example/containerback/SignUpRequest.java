package com.example.containerback;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequest {
    private String id;
    private String password;
    private String password2;
    private String call;
    private String addepartment;
    private String adposition;
    private String name;
}
