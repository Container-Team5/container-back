package com.example.containerback.controller;

import com.example.containerback.model.Memo;
import com.example.containerback.model.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MemoController {
    @Autowired
    private MemoRepository memoRepository;

    @PostMapping("/memo")
    public Memo create(@RequestBody Memo memo) {
        return memoRepository.save(memo);
    }
    @GetMapping("/memo/{id}")
    public String read(@PathVariable Long id) {

        Optional<Memo> memoOptional = memoRepository.findById(id);
        memoOptional.ifPresent(System.out::println);

        return "successfully executed";
    }
}
