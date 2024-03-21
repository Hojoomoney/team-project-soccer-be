package com.rod.api.board;

import com.rod.api.article.Article;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Board {
    @Id
    @Column(name = "board_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String boardName;

    @Column
    private String boardType;

    @OneToMany(mappedBy ="board")
    private List<Article> articles;

    @Builder(builderMethodName = "builder")
    public Board(String boardName, String boardType) {
        this.boardName = boardName;
        this.boardType = boardType;
    }
}
