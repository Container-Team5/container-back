package com.example.containerback.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    @Size(min=3, max=20)
    @NotEmpty(message = "비밀 번호는 필수 항목 입니다.")
    private String uPwd1;

    @NotEmpty(message = "비밀 번호는 필수 항목 입니다.")
    private String uPwd2;

    @NotEmpty(message = "업체명은 필수 항목 입니다.")
    private String facName;

    @NotEmpty(message = "대표자 이름은 필수 항목 입니다.")
    private String rep;

    @NotEmpty(message = "전화 번호는 필수 항목 입니다.")
    private String facCall;

    @NotEmpty(message = "주소는 필수 항목 입니다.")
    private String location;
}
