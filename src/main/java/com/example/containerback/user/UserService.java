package com.example.containerback.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User create(String uPwd, String facName, String rep, String facCall, String location) {
        User user = new User();
        user.setUPwd(passwordEncoder.encode(uPwd));
        user.setFacName(facName);
        user.setRep(rep);
        user.setFacCall(facCall);
        user.setLocation(location);
        this.userRepository.save(user);
        return user;
    }
}
