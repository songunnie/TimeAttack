package com.example.java0617.service;

import com.example.java0617.domain.User;
import com.example.java0617.dto.user.UserLoginRequestDto;
import com.example.java0617.dto.user.UserLoginResponseDto;
import com.example.java0617.dto.user.UserSaveRequestDto;
import com.example.java0617.dto.user.UserSaveResponseDto;
import com.example.java0617.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserSaveResponseDto join(UserSaveRequestDto userSaveRequestDto) {
        User user = User.builder()
                .id(userSaveRequestDto.getId())
                .password(userSaveRequestDto.getPassword())
                .name(userSaveRequestDto.getName())
                .age(userSaveRequestDto.getAge())
                .gender(userSaveRequestDto.getGender())
                .build();

        userRepository.save(user);

        return UserSaveResponseDto.builder()
                .id(user.getId())
                .name(User.getName())
                .build();
    }

    public UserLoginResponseDto login(UserLoginRequestDto UserLoginRequestDto) {
        User user = userRepository.findById(userLoginRequestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자 이메일"));

        if (passwordEncoder.matches(user.getPassword(), userLoginRequestDto.getPassword())) {
            throw new IllegalArgumentException("유효하지 않은 비밀번호");
        }

        return UserLoginResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
