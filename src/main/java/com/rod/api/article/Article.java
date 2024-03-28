package com.rod.api.article;


import com.rod.api.board.Board;
import com.rod.api.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name="articles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Article {
   @Id
   @Column(name = "article_id", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String title;
   private String content;
   private LocalDateTime registerDate;

   @ManyToOne
   @JoinColumn(name = "board_id")
   private Board board;

   @ManyToOne
   @JoinColumn(name = "writer_id")
   private User writer;

}
