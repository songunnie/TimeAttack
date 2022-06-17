package com.example.java0617.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserTokenResponseDto {

    private String token;
}
