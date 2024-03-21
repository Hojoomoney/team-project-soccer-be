package com.rod.api.article;


import com.rod.api.board.Board;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="article")
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


   @ManyToOne
   @JoinColumn(name = "board_id")
   private Board board;

   @Builder(builderMethodName = "builder")
   public Article(Long id, String title, String content, String writer) {
      this.id = id;
      this.title = title;
      this.content = content;
      this.writer = writer;
   }
}
