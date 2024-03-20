package com.rod.api.user;

import com.rod.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    Messenger save(User user) throws SQLException;

    List<User> findAll() throws SQLException;

    Messenger createMemberTable() throws SQLException;

    String deleteMemberTable() throws SQLException;

}
