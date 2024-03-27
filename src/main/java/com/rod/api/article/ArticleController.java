package com.rod.api.article;

import com.rod.api.enums.Messenger;
import com.rod.api.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    @GetMapping("/api/articles")
    public Map<?,?> findAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", Messenger.SUCCESS);
//        list.add(Article.builder()
//                        .title("제목입니다")
//                        .content("내용입니다")
//                        .writer("작성자입니다")
//                        .registerDate(LocalDateTime.now())
//                        .build());
        List<Article> list = (List<Article>) articleService.findAll();
        map.put("result", list);
        return map;
    }
}
