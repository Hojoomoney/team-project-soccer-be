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
    default Article dtoToEntity(ArticleDto dto){    //dto 를 entity로 바꾸는 것
        return Article.builder().build();
    }

    default ArticleDto entityToDto(Optional<Article> ent){ //entity 를 dto로 바꾸는 것
        return ArticleDto.builder().build();
    }
}
