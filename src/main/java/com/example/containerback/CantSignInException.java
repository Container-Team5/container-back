package com.example.containerback;

public class CantSignInException extends RuntimeException {
    /**
     * ID: userId 회원가입이 되어있지 않거나 잠긴 계정입니다.
     *
     * @param userId 인증이 불가한 사용자 아이디
     */
    public CantSignInException(String userId) {
        super("ID: " + userId + " 회원가입이 되어있지 않거나 잠긴 계정입니다.");
    }
}
