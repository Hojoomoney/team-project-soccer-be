package com.rod.api.board;

import com.rod.api.article.Article;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="boards")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Board {
    @Id
    @Column(name = "board_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;
    private String boardType;

    @OneToMany(mappedBy ="board")
    private List<Article> articles;

}
