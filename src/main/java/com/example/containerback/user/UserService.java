package com.example.containerback.user;

import com.example.containerback.user.User;
import com.example.containerback.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User registUser(User user) {
        return userRepository.save(user);
    }
}