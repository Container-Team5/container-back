package com.example.containerback.admin;

import com.example.containerback.*;
import com.example.containerback.exception.CantSignInException;
import com.example.containerback.exception.IdAlreadyExistsException;
import com.example.containerback.request.RefreshRequest;
import com.example.containerback.request.SignUpRequest;
import com.example.containerback.response.RefreshResponse;
import com.example.containerback.response.SignInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AdminRepository adminRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    /**
     * 인증토큰 발급받기
     * 새로 로그인 할 때마다 RefreshToken 이 갱신된다.
     *
     * @param userId       사용자 ID
     * @param password 사용자 비밀번호
     * @return accessToken
     * @throws CantSignInException 회원가입이 되어있지 않거나 잠긴 계정입니다.
     */
    @Transactional
    public SignInResponse signIn(String userId, String password) {
        Admin admin = this.adminRepository.findByUserIdAndState(userId, UserStatus.NORMAL, Admin.class)
                .orElseThrow(() -> new CantSignInException(userId));
        if (!passwordEncoder.matches(password, admin.getPassword()))
            throw new CantSignInException(userId);
        admin.updateRefreshToken(jwtTokenProvider.createRefreshToken(admin.getPassword(), admin.getRoles()));

        return SignInResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(admin.getUserId(), admin.getRoles()))
                .refreshToken(admin.getRefreshToken())
                .build();
    }

    @Transactional
    public SignInResponse signUp(SignUpRequest signUpRequest) {
        Admin admin = adminRepository.save(
                new Admin(
                        signUpRequest.getUserId(),
                        passwordEncoder.encode(signUpRequest.getPassword()),
                        signUpRequest.getFacName(),
                        signUpRequest.getAdName(),
                        signUpRequest.getRep(),
                        signUpRequest.getDepartment(),
                        signUpRequest.getPosition(),
                        signUpRequest.getAdmCall(),
                        signUpRequest.getLocation(),
                        UserStatus.NORMAL,
                        jwtTokenProvider.createRefreshToken(signUpRequest.getUserId(),Collections.singletonList(UserRole.ROLE_USER)),
                        Collections.singletonList(signUpRequest.getRole())
                ));

        return SignInResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(admin.getUserId(), admin.getRoles()))
                .refreshToken(admin.getRefreshToken())
                .build();
    }

    /**
     * 중복 아이디 체크
     *
     * @param userId 사용자 ID
     * @throws IdAlreadyExistsException 이미 사용중인 아이디입니다.
     */
    @Transactional(readOnly = true)
    public void idCheck(String userId) {
        if (this.adminRepository.findByUserIdAndStateIsNot(userId, UserStatus.WITHDRAWAL).isPresent())
            throw new IdAlreadyExistsException(userId);
    }

    /**
     * RefreshToken 으로 AccessToken 재발급
     *
     * @param refreshRequest AccessToken, RefreshToken
     * @return AccessToken
     */
    @Transactional
    public RefreshResponse refreshAccessToken(RefreshRequest refreshRequest) {
        String refreshId = jwtTokenProvider.getUserId(jwtTokenProvider.getClaimsFromToken(refreshRequest.getRefreshToken()));
        Admin admin = adminRepository.findByUserIdAndStateAndRefreshToken(refreshId, UserStatus.NORMAL, refreshRequest.getRefreshToken())
                .orElseThrow(() -> new CantSignInException(refreshId));

        return RefreshResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(admin.getUserId(), admin.getRoles()))
                .build();
    }


}