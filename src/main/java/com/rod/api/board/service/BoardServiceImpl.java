package com.rod.api.board.service;

import com.rod.api.board.model.BoardDto;
import com.rod.api.board.repository.BoardRepository;
import com.rod.api.common.component.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository repository;


    @Override
    public Messenger save(BoardDto t) throws SQLException {
        repository.save(dtoToEntity(t));
        return new Messenger();
    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return new Messenger();
    }

    @Override
    public Messenger modify(BoardDto boardDto) {
        return null;
    }

    @Override
    public List<BoardDto> findAll() throws SQLException {
        return repository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public Optional<BoardDto> findById(Long id) {
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
}
