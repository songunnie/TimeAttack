package com.example.java0617.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name="USERS")
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_age")
    private int userAge;

    @Column(name = "user_email")
    private String userGender;

}
