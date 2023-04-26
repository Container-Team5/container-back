package com.example.containerback.admin;

import com.example.containerback.form.AdminCreateForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/signup")
    public String signup(AdminCreateForm adminCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid AdminCreateForm adminCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!adminCreateForm.getAdPwd1().equals(adminCreateForm.getAdPwd2())) {
            bindingResult.rejectValue("adPwd2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }
        adminService.create(adminCreateForm.getAdId(),
                adminCreateForm.getAdPwd1(), adminCreateForm.getAdName(), adminCreateForm.getDepartment(), adminCreateForm.getPosition(), adminCreateForm.getAdmCall());

        return "redirect:/";
    }
}
