package com.example.containerback.admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByIDAndPasswd(final String adId, final String adPwd);
}
