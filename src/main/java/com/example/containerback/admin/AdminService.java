package com.example.containerback.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public Admin registAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}