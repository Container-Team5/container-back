package com.example.containerback.model;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    private Long uId;  // 사용자 ID
    
    @Column(length = 20, nullable = false)
    private String uPwd;  // 사용자 비밀 번호
    
    @Column(nullable = false)
    private String facName;  // 물류 업체명
    
    @Column(nullable = false)
    private String rep;  // 대표자
    
    @Column(length = 15, nullable = false)
    private String facCall;  // 전화 번호
    
    @Column(length = 200, nullable = false)
    private String location;  // 위치
}
