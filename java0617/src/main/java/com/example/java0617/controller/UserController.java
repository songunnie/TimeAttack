package com.example.java0617.controller;

import com.example.java0617.dto.user.*;
import com.example.java0617.service.UserService;
import com.example.java0617.util.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public UserSaveResponseDto saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        userSaveRequestDto.setPassword(passwordEncoder.encode(userSaveRequestDto.getPassword()));

        return userService.join(userSaveRequestDto);
    }

    @PostMapping("/login")
    public UserTokenResponseDto login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        UserLoginResponseDto result = userService.login(userLoginRequestDto);

        Authentication authentication = new UsernamePasswordAuthenticationToken(result.getId(), null);
        String token = JwtTokenProvider.generateToken(authentication);

        return UserTokenResponseDto.builder()
                .token(token)
                .build();
    }
}
