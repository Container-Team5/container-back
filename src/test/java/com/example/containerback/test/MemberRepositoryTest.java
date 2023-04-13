package com.example.containerback.test;

import com.example.containerback.model.Member;
import com.example.containerback.model.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    /*public void InsertDummies() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("kanginleeoficial", "hmson7", "todaysang", "hjso30", "park0hyun"));
        ArrayList<String> pwd = new ArrayList<>(Arrays.asList("ki021918", "hmson07", "wonsang11", "hj091630", "yh101160"));
        IntStream.rangeClosed(1, names.size()-1).forEach(i -> {

            Member member = Member.builder()
                    .userName(names.get(i))
                    .password(pwd.get(i))
                    .build();
            //Create!
            memberRepository.save(member);
        });
    }*/
    public void SelectDummies() {

        String id = "";

        Optional<Member> result = memberRepository.findById(id);

        System.out.println("=============================");

        if(result.isPresent()) {
            Member member = result.get();
            System.out.println(member);
        }
    }
    /*public void UpdateDummies() {
        Member member = Member.builder()
                .userName(10L)
                .password("thisisFake")
                .build();

        containerRepository.save(container);
    }*/
}