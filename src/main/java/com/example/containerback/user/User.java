package com.example.containerback.user;

import com.example.containerback.admin.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@ToString
@Getter
@Setter
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

    @Column
    private String refreshToken;
    @Column
    private UserStatus userStatus;

    public User(Long uId, String uPwd, String facName, String rep, String facCall, String location, UserStatus userStatus, String refreshToken) {
        this.uId = uId;
        this.uPwd = uPwd;
        this.facName = facName;
        this.rep = rep;
        this.facCall = facCall;
        this.location = location;
        this.userStatus = userStatus;
        this.refreshToken = refreshToken;
    }

    public void updateRefreshToken(String refreshToken) { this.refreshToken = refreshToken; }

}
