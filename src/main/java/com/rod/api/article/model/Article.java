package com.rod.api.article.model;


import com.rod.api.board.model.Board;
import com.rod.api.common.BaseEntity;
import com.rod.api.user.model.User;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="articles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Article extends BaseEntity {
   @Id
   @Column(name = "article_id", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String title;
   private String content;

   @ManyToOne
   @JoinColumn(name = "board_id")
   private Board board;

   @ManyToOne
   @JoinColumn(name = "writer_id")
   private User writer;

}
