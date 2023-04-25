package com.example.containerback.domain;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Member")
@Entity
public class Member {
    @Id
    private String userName;  // 사용자 ID

    @Column(length = 20, nullable = false)
    private String password;  // 비밀번호
}
