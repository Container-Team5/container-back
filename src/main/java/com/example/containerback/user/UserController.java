package com.example.containerback.user;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user", produces = MediaTypes.HAL_JSON_VALUE)
public class UserController {
//    private final UserService userService;
//
//    @GetMapping("/signup")
//    public String signup(UserCreateForm userCreateForm) {
//        return "signup_form";
//    }
//
//    @PostMapping("/signup")
//    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "signup_form";
//        }
//
//        if (!userCreateForm.getUPwd1().equals(userCreateForm.getUPwd2())) {
//            bindingResult.rejectValue("uPwd2", "passwordInCorrect",
//                    "2개의 패스워드가 일치하지 않습니다");
//            return "signup_form";
//        }
//        userService.create(userCreateForm.getUPwd1(), userCreateForm.getFacName(), userCreateForm.getRep(),
//                userCreateForm.getFacCall(), userCreateForm.getLocation());
//
//        return "redirect:/";
//    }
//
//    @GetMapping("/login")
//    public String login() {
//        return "login_form";
//    }
}
