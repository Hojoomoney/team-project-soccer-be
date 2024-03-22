package com.rod.api.user;

import com.rod.api.order.Order;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity(name="users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class User {
    @Id
    @Column(name="user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Setter
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String job;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;


    @Builder(builderMethodName = "builder")
    public User(String username, String password,String email, String name, String phone, String job) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.job = job;
    }

}

