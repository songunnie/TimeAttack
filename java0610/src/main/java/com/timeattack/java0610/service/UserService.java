package com.timeattack.java0610.service;

import com.timeattack.java0610.domain.User;
import com.timeattack.java0610.domain.UserRepository;

import javax.transaction.Transactional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Long update(Long id, User user) {
        User user1 = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        user1.update(user);
        return user.getId();
    }
}
