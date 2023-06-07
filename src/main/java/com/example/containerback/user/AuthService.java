package com.example.containerback.user;

import com.example.containerback.*;
import com.example.containerback.exception.CantSignInException;
import com.example.containerback.exception.IdAlreadyExistsException;
import com.example.containerback.palette.Palette;
import com.example.containerback.palette.PaletteRepository;
import com.example.containerback.request.RefreshRequest;
import com.example.containerback.request.SignUpRequest;
import com.example.containerback.response.RefreshResponse;
import com.example.containerback.response.SignInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final PaletteRepository paletteRepository;
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
        User user = this.userRepository.findByUserIdAndState(userId, UserStatus.NORMAL, User.class)
                .orElseThrow(() -> new CantSignInException(userId));
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new CantSignInException(userId);
        user.updateRefreshToken(jwtTokenProvider.createRefreshToken(user.getPassword(), user.getRoles()));

        return SignInResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(user.getUserId(), user.getRoles()))
                .refreshToken(user.getRefreshToken())
                .build();
    }

    @Transactional
    public SignInResponse signUp(SignUpRequest signUpRequest) {
        User user = userRepository.save(
                new User(
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
                .accessToken(jwtTokenProvider.createAccessToken(user.getUserId(), user.getRoles()))
                .refreshToken(user.getRefreshToken())
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
        if (this.userRepository.findByUserIdAndStateIsNot(userId, UserStatus.WITHDRAWAL).isPresent())
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
        User user = userRepository.findByUserIdAndStateAndRefreshToken(refreshId, UserStatus.NORMAL, refreshRequest.getRefreshToken())
                .orElseThrow(() -> new CantSignInException(refreshId));

        return RefreshResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(user.getUserId(), user.getRoles()))
                .build();
    }

    @Transactional
    public User orderPalettesToAdmin(Long IndexAdId, Long paletteId) {
        Set<Palette> paletteSet = null;
        User user = userRepository.findById(IndexAdId).get();
        Palette palette = paletteRepository.findById(paletteId).get();
        palette.setUser(user);
//        paletteSet = admin.
//        paletteSet.add(palette);
//        admin.setOrderpalettes(paletteSet);
//        return adminRepository.save(admin);
        return user;
    }

    @Transactional
    public Long getIndexId(String userId) {
        User user = userRepository.findAdminsByUserId(userId);
        Long indexId = user.getIndexAdId();
        return indexId;
    }



}