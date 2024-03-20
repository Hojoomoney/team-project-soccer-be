package com.rod.api.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString

public class Account {
    private Long id;
    private String username;
    private String password;
    private String passwordCfm;
    private String name;
    private String phoneNum;


}
