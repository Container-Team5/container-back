package com.example.containerback.user;

import com.example.containerback.JwtUserTokenProvider;
import com.example.containerback.admin.UserStatus;
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
public class UserAuthService {

    private final UserRepository userRepository;
    private final JwtUserTokenProvider jwtUserTokenProvider;
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
    public SignInResponse signIn(Long id, String password) {
        User user = this.userRepository.findByUIdAndUserStatus(id, UserStatus.NORMAL, User.class)
                .orElseThrow(() -> new CantSignInException(id.toString()));
        if (!passwordEncoder.matches(password, user.getUPwd()))
            throw new CantSignInException(id.toString());
        user.updateRefreshToken(jwtUserTokenProvider.createRefreshToken(user.getUId()));

        return SignInResponse.builder()
                .accessToken(jwtUserTokenProvider.createAccessToken(user.getUId()))
                .refreshToken(user.getRefreshToken())
                .build();
    }

    /**
     * 회원 가입 하기
     * 회원가입과 동시에 인증토큰 발급
     *
     * @param id       사용자 ID
     * @param password 사용자 비밀번호
     * @param facName     업체명
     * @return accessToken
     */
    @Transactional
    public SignInResponse signUp(Long id, String password, String facName, String rep, String facCall, String location) {
        User user = userRepository.save(
                new User(
                        id,
                        passwordEncoder.encode(password),
                        facName,
                        rep,
                        facCall,
                        location,
                        UserStatus.NORMAL,
                        jwtUserTokenProvider.createRefreshToken(id)
                ));
        return SignInResponse.builder()
                .accessToken(jwtUserTokenProvider.createAccessToken(user.getUId()))
                .refreshToken(user.getRefreshToken())
                .build();
    }

    /**
     * 중복 아이디 체크
     *
     * @param id 사용자 ID
     * @throws IdAlreadyExistsException 이미 사용중인 아이디입니다.
     */
    @Transactional(readOnly = true)
    public void idCheck(Long id) {
        if (this.userRepository.findByUIdAndUserStatusIsNot(id, UserStatus.WITHDRAWAL).isPresent())
            throw new IdAlreadyExistsException(id.toString());
    }

    /**
     * RefreshToken 으로 AccessToken 재발급
     *
     * @param refreshRequest AccessToken, RefreshToken
     * @return AccessToken
     */
    @Transactional
    public RefreshResponse refreshAccessToken(RefreshRequest refreshRequest) {
        String refreshId = jwtUserTokenProvider.getUId(jwtUserTokenProvider.getClaimsFromToken(refreshRequest.getRefreshToken()));
        User user = userRepository.findByUIdAndUserStatusAndRefreshToken(Long.parseLong(refreshId), UserStatus.NORMAL, refreshRequest.getRefreshToken())
                .orElseThrow(() -> new CantSignInException(refreshId));

        return RefreshResponse.builder()
                .accessToken(jwtUserTokenProvider.createAccessToken(user.getUId()))
                .build();
    }
}
