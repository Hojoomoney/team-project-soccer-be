package com.rod.api.board.model;

import com.rod.api.article.model.Article;
import com.rod.api.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="boards")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Board extends BaseEntity {
    @Id
    @Column(name = "board_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String boardName;
    @Setter
    private String boardType;

    @OneToMany(mappedBy ="board", fetch = FetchType.LAZY)
    private List<Article> articles;

}
