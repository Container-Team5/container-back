package com.example.containerback.request;


import com.example.containerback.admin.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequest {
    private String userId;
    private String password;
    public String admCall;
    private String department;
    private String position;
    private String facName;
    private String adName;
    private String rep;
    private String location;
    private UserRole role;

}