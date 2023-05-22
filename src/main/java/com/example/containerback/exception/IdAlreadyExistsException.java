package com.example.containerback.exception;

public class IdAlreadyExistsException extends RuntimeException {
    /**
     * ID: userId 이미 사용중인 아이디입니다.
     *
     * @param userId 이미 사용중인 아이디
     */
    public IdAlreadyExistsException(String userId) {
        super("ID: " + userId + " 이미 사용중인 아이디입니다.");
    }
}
