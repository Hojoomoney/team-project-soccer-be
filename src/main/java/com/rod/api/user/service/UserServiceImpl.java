package com.rod.api.user.service;

import com.rod.api.common.component.Messenger;
import com.rod.api.user.model.User;
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
    public Messenger save(UserDto t) throws SQLException {
        entityToDto((repository.save(dtoToEntity(t))));
        return Messenger.builder()
                .message(repository.existsById(t.getId()) ? "SUCCESS" : "FAILURE")
                .build();
    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return Messenger.builder()
                .message(repository.existsById(id) ? "FAILURE" : "SUCCESS")
                .build();
    }

    @Override
    public List<UserDto> findAll() throws SQLException {
        return repository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
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
    public Messenger modify(UserDto userDto) {
        User user = repository.findById(userDto.getId()).orElseThrow(null);
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setJob(userDto.getJob());
        repository.save(user);
        return Messenger.builder()
                .message(repository.existsById(user.getId()) ? "SUCCESS" : "FAILURE")
                .build();
    }

    @Override
    public List<UserDto> findUsersByName(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'findUsersByName'");
    }

    @Override
    public List<UserDto> findUsersByJob(String job) {
        throw new UnsupportedOperationException("Unimplemented method 'findUsersByJob'");
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Messenger login(UserDto param) {
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
}
