package com.example.java0617.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserLoginResponseDto {

    private String id;
    private String name;
}
