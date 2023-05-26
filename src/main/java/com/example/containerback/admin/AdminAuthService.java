package com.example.containerback.admin;

import com.example.containerback.*;
import com.example.containerback.exception.CantSignInException;
import com.example.containerback.exception.IdAlreadyExistsException;
import com.example.containerback.request.RefreshRequest;
import com.example.containerback.response.RefreshResponse;
import com.example.containerback.response.SignInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminAuthService {

    private final AdminRepository adminRepository;
    private final JwtAdminTokenProvider jwtAdminTokenProvider;
    private final PasswordEncoder passwordEncoder;

    /**
     * 인증토큰 발급받기
     * 새로 로그인 할 때마다 RefreshToken 이 갱신된다.
     *
     * @param id       사용자 ID
     * @param password 사용자 비밀번호
     * @return accessToken
     * @throws CantSignInException 회원가입이 되어있지 않거나 잠긴 계정입니다.
     */
    @Transactional
    public SignInResponse signIn(String id, String password) {
        Admin admin = this.adminRepository.findByAdIdAndState(id, UserStatus.NORMAL, Admin.class)
                .orElseThrow(() -> new CantSignInException(id));
        if (!passwordEncoder.matches(password, admin.getAdPwd()))
            throw new CantSignInException(id);
        admin.updateRefreshToken(jwtAdminTokenProvider.createRefreshToken(admin.getAdId()));

        return SignInResponse.builder()
                .accessToken(jwtAdminTokenProvider.createAccessToken(admin.getAdId()))
                .refreshToken(admin.getRefreshToken())
                .build();
    }

    /**
     * 회원 가입 하기
     * 회원가입과 동시에 인증토큰 발급
     *
     * @param id       사용자 ID
     * @param password 사용자 비밀번호
     * @param name     사용자 이름
     * @return accessToken
     */
    @Transactional
    public SignInResponse signUp(String id, String password, String name, String department, String position, String admCall) {
        Admin admin = adminRepository.save(
                new Admin(
                        id,
                        passwordEncoder.encode(password),
                        name,
                        department,
                        position,
                        admCall,
                        UserStatus.NORMAL,
                        jwtAdminTokenProvider.createRefreshToken(id)
                ));

        return SignInResponse.builder()
                .accessToken(jwtAdminTokenProvider.createAccessToken(admin.getAdId()))
                .refreshToken(admin.getRefreshToken())
                .build();
    }

    /**
     * 중복 아이디 체크
     *
     * @param id 사용자 ID
     * @throws IdAlreadyExistsException 이미 사용중인 아이디입니다.
     */
    @Transactional(readOnly = true)
    public void idCheck(String id) {
        if (this.adminRepository.findByAdIdAndStateIsNot(id, UserStatus.WITHDRAWAL).isPresent())
            throw new IdAlreadyExistsException(id);
    }

    /**
     * RefreshToken 으로 AccessToken 재발급
     *
     * @param refreshRequest AccessToken, RefreshToken
     * @return AccessToken
     */
    @Transactional
    public RefreshResponse refreshAccessToken(RefreshRequest refreshRequest) {
        String refreshId = jwtAdminTokenProvider.getAdId(jwtAdminTokenProvider.getClaimsFromToken(refreshRequest.getRefreshToken()));
        Admin admin = adminRepository.findByAdIdAndStateAndRefreshToken(refreshId, UserStatus.NORMAL, refreshRequest.getRefreshToken())
                .orElseThrow(() -> new CantSignInException(refreshId));

        return RefreshResponse.builder()
                .accessToken(jwtAdminTokenProvider.createAccessToken(admin.getAdId()))
                .build();
    }
}
