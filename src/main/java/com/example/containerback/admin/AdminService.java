package com.example.containerback.admin;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public Admin findBy(final Admin params) {
        Admin admin = adminRepository.findByIDAndPasswd(params.getAdId(), params.getAdPwd());
        return admin;
    }
}
