package com.example.containerback.admin;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public Admin create(String adId, String adPwd, String adName, String department, String position, String admCall) {
        Admin admin = new Admin();
        admin.setAdId(adId); //회원가입시 기입한 관리자 ID
        admin.setAdName(adName); //관리자명
        admin.setDepartment(department); //관리자 부서
        admin.setPosition(position); //관리자 직책
        admin.setAdmCall(admCall); //관리자 전화번호
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //PW 암호화
        admin.setAdPwd(passwordEncoder.encode(adPwd)); //관리자 PW
        this.adminRepository.save(admin);
        return admin;


    }
}