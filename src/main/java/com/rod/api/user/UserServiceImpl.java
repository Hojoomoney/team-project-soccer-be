package com.rod.api.user;

import com.rod.api.common.AbstractService;
import com.rod.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public Messenger createMemberTable() throws SQLException {
        return userRepository.createMemberTable();
    }

    @Override
    public String deleteMemberTable() throws SQLException {
        return userRepository.deleteMemberTable();
    }



    @Override
    public Messenger save(User user) throws SQLException {
        userRepository.save(user);
        return Messenger.SUCCESS;
    }

    @Override
    public List<User> findAll() throws SQLException {
        return userRepository.findAll();
    }


}
