package com.rod.api.article.service;

import com.rod.api.article.model.Article;
import com.rod.api.article.model.ArticleDto;
import com.rod.api.article.repository.ArticleRepository;
import com.rod.api.common.component.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository repository;
    @Override
    public Messenger save(ArticleDto t) throws SQLException {
        entityToDto(repository.save(dtoToEntity(t)));
        return new Messenger();
    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return new Messenger();
    }

    @Override
    public Messenger modify(ArticleDto articleDto) {
        Article article = repository.findById(articleDto.getId()).orElseThrow(null);
        article.setTitle(articleDto.getTitle());
        article.setContent(articleDto.getContent());
        repository.save(article);
        return new Messenger();
    }

    @Override
    public List<ArticleDto> findAll() throws SQLException {
        return repository.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<ArticleDto> findById(Long id) {
        return repository.findById(id).map(this::entityToDto);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public boolean existById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<ArticleDto> findArticlesByTitle(String title) {
        throw new UnsupportedOperationException("Unimplemented method 'updatePassword'");
    }

    @Override
    public List<ArticleDto> findArticlesByContent(String content) {
        throw new UnsupportedOperationException("Unimplemented method 'updatePassword'");
    }
}
