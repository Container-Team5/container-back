package com.example.containerback.admin;

import jakarta.persistence.*;
import lombok.*;
@ToString
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Admin")
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    private Long IndexAdId;  // 관리자 ID index

    @Column(name = "ad_Id", nullable = false)
    private String adId; //회원가입시 기입한 관리자 ID
    @Column(length = 20, nullable = false)
    private String adPwd;  // 관리자 비밀번호
    
    @Column(nullable = false)
    private String adName;  // 관리자명
    
    @Column(nullable = false)
    private String department;  // 부서
    
    @Column(nullable = false)
    private String position;  // 직책
    
    @Column(length = 15, nullable = false)
    private String admCall;  // 전화번호

    @Column
    private String refreshToken; //RefreshToken

    @Column
    private UserStatus state; //회원 관리 상태

}
