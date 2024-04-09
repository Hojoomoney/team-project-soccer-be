package com.rod.api.article.service;

import com.rod.api.article.model.Article;
import com.rod.api.article.model.ArticleDto;
import com.rod.api.common.service.CommandService;
import com.rod.api.common.service.QueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {
    // 디폴트 메소드는 로직도 똑같을 때 선언
    List<ArticleDto> findArticlesByTitle(String title);
    List<ArticleDto> findArticlesByContent(String content);
    default Article dtoToEntity(ArticleDto dto){    //dto 를 entity로 바꾸는 것
        return Article.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }

    default ArticleDto entityToDto(Article ent){ //entity 를 dto로 바꾸는 것
        return ArticleDto.builder()
                .id(ent.getId())
                .title(ent.getTitle())
                .content(ent.getContent())
                .build();
    }
}
