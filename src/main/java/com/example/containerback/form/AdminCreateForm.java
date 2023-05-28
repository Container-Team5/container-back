package com.example.containerback.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminCreateForm {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "사용자ID는 필수항목입니다.")
    private String adId;

    @Size(min = 8, max = 16)
    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String adPwd1;

    @NotEmpty(message = "비밀번호 확인 필수항목입니다.")
    private String adPwd2;

    @NotEmpty(message = "연락처는 필수항목입니다.")
    private String admCall;

    @NotEmpty(message = "관리자명은 필수항목입니다.")
    private String adName;

    @NotEmpty(message = "부서는 필수항목입니다.")
    private String department;

    @NotEmpty(message = "직책은 필수항목입니다.")
    private String position;

}
