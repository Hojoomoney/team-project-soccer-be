package com.rod.api.user.model;

import com.rod.api.article.model.Article;
import com.rod.api.common.BaseEntity;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@Builder
@ToString(exclude = {"id"})
@Entity(name="users")
public class User extends BaseEntity {
    @Id
    @Column(name="user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Setter
    private String password;
    private String email;
    private String name;
    @Setter
    private String phone;
    @Setter
    private String job;

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    private List<Article> articles;
}



