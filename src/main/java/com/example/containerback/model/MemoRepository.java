package com.example.containerback.model;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.containerback.model.Memo;
public interface MemoRepository extends JpaRepository<Memo, Long> {
}
