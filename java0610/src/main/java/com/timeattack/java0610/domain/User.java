package com.timeattack.java0610.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class User extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private int gender; //0이면 남자, 1이면 여자.

    public User(Long id, String email, String name, int age, int gender) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void update(User user) {
        this.name = user.name;
        this.age = user.age;
        this.gender = user.gender;
    }
}
