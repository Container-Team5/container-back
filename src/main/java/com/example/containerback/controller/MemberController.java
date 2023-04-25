package com.example.containerback.controller;

import com.example.containerback.domain.Member;
import com.example.containerback.domain.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/member")
    public Member create(@RequestBody Member member) { return memberRepository.save(member); }

    @GetMapping("/member/{id}")
    public String read(@PathVariable String id) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        memberOptional.ifPresent(System.out::println);

        return "successfully executed";
    }
}
