package com.rod.api.article;


import com.rod.api.board.Board;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name="articles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Article {
   @Id
   @Column(name = "article_id", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String title;

   @Column
   private String content;

   @Column
   private String writer;

   @Column
   private LocalDateTime registerDate;

   @ManyToOne
   @JoinColumn(name = "board_id")
   private Board board;

   @Builder(builderMethodName = "builder")
   public Article(String title, String content, String writer, LocalDateTime registerDate) {
      this.title = title;
      this.content = content;
      this.writer = writer;
      this.registerDate = registerDate;
   }
}
