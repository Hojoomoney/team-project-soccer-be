package com.rod.api.user;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class User {
    private Long id;
    private String username;
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

    public void setPassword(String password) {
        this.password = password;
    }
}

