package com.timeattack.java0610.controller;


import com.timeattack.java0610.domain.User;
import com.timeattack.java0610.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/read/{id}")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody UserRequestDto requestDto) { //Dto 아직 못만들었어요 ㅠ
        return userService.update(id, requestDto);
    }
}
