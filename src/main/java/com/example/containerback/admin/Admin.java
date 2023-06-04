package com.example.containerback.admin;

import com.example.containerback.palette.Palette;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Long IndexAdId;  // ID index 관리자, 사옹자

    @Column(nullable = false)
    private String userId; //회원가입시 기입한  ID
    @Column(length = 500, nullable = false)
    private String password;  // 관리자 비밀번호

    @Column
    private String facName;  // 물류 업체명
    
    @Column
    private String adName;  // 관리자명

    @Column
    private String rep;  // 대표자
    
    @Column
    private String department;  // 부서
    
    @Column
    private String position;  // 직책
    
    @Column(length = 15)
    private String admCall;  // 전화번호

    @Column(length = 200)
    private String location;  // 위치

    @Column
    private String refreshToken; //RefreshToken

    @Column
    private UserStatus state; //회원 관리 상태

    @ElementCollection(fetch = FetchType.LAZY)
    private List<UserRole> roles;

    @ManyToMany
    @JoinTable(name = "orderpalette",
            joinColumns = @JoinColumn(name = "index_ad_id"),
            inverseJoinColumns = @JoinColumn(name = "palette_id")
    )
    private Set<Palette> orderpalettes = new HashSet<>();

    public Admin(String userId, String password, String facName, String adName, String rep, String department, String position, String admCall, String location, UserStatus state, String refreshToken, List<UserRole> roles) {
        this.userId = userId;
        this.password = password;
        this.facName = facName;
        this.adName = adName;
        this.rep = rep;
        this.department = department;
        this.position = position;
        this.admCall = admCall;
        this.location = location;
        this.state = state;
        this.refreshToken = refreshToken;
        this.roles = roles;
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}
