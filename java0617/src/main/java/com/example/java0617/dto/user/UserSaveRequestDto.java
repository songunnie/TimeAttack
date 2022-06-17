package com.example.java0617.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSaveRequestDto {

    private String id;
    private String password;
    private String name;
}
