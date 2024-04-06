package com.rod.api.user.service;

import com.rod.api.user.model.UserDto;
import com.rod.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;


    @Override
    public UserDto save(UserDto t) throws SQLException {
        return entityToDto(repository.save(dtoToEntity(t)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserDto> findAll() throws SQLException {
        return repository.findAll().stream().map(i -> entityToDto(i)).toList();
    }
    @Override
    public Optional<UserDto> findById(Long id) {
        //return entityToDto(repository.findById(id));
        return null;
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
