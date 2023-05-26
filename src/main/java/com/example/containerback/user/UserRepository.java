package com.example.containerback.user;

import com.example.containerback.admin.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    <T> Optional<T> findByUIdAndUserStatus(Long uId, UserStatus userStatus, Class<T> Class);
    //계정 ID와 제외된 상태로 조회
    Optional<UserIdDto> findByUIdAndUserStatusIsNot(Long uId, UserStatus userStatus);
    //계정 ID와 상태로 종회
    Optional<User> findByUIdAndUserStatusAndRefreshToken(Long uId, UserStatus userStatus, String refreshToken);
}
