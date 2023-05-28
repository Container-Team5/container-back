package com.example.containerback.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    //계정 ID와 상태로 조회
    <T> Optional<T> findByUserIdAndState(String userId, UserStatus state, Class<T> Class);
    //계정 ID와 제외된 상태로 조회
    Optional<AdminIdDto> findByUserIdAndStateIsNot(String userId, UserStatus state);
    //계정 ID와 상태로 종회
    Optional<Admin> findByUserIdAndStateAndRefreshToken(String userId, UserStatus state, String refreshToken);
}
