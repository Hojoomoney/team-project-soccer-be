package com.rod.api.user;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class User {
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @Setter
    private String password;
    private String name;
    private String phone;
    private String job;
    private String height;
    private String weight;

    @Builder(builderMethodName = "builder")
    public User(String username, String password, String name, String phone, String job, String height, String weight) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }

}

