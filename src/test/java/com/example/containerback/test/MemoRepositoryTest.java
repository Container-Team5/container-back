package com.example.containerback.test;

import com.example.containerback.model.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MemoRepositoryTest {
    @Autowired
    MemoRepository memoRepository;

    @Test
    /*public void InsertDummies() {

        IntStream.rangeClosed(1, 10).forEach(i -> {
            Memo memo = Memo.builder()
                    .memoText("Sample..." + i)
                    .build();
            //Create!
            memoRepository.save(memo);
        });
    }*/
    /*public void SelectDummies() {

        Long id = 10L;

        Optional<Memo> result = memoRepository.findById(id);

        System.out.println("=============================");

        if(result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        }
    }*/
    /*public void UpdateDummies() {
        Memo memo = Memo.builder()
                .id(10L)
                .memoText("Update Text")
                .build();

        memoRepository.save(memo);
    }*/
    public void DeleteDummies() {
        Long id = 10L;

        memoRepository.deleteById(id);
    }
}