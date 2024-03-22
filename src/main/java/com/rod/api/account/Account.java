package com.rod.api.account;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="account")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Account {
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String money;

    @Builder(builderMethodName = "builder")
    public Account(Long id, String money) {
        this.id = id;
        this.money = money;
    }
}
