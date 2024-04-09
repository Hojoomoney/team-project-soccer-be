package com.rod.api.user.model;

import com.rod.api.article.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //Object 같은거
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String phone;
    private String job;
    private String regDate;
    private String modDate;
    private List<Article> articles;
}
