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
    private String name;
    @Column
    private String phone;
    @OneToMany(mappedBy = "user")
    private List<Order> orders;


    @Builder(builderMethodName = "builder")
    public User(String username, String password, String name, String phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

}

