package com.rod.api.common.service;

import com.rod.api.common.component.Messenger;

import java.sql.SQLException;

public interface CommandService<T> {
    Messenger save(T t) throws SQLException;
    Messenger deleteById(Long id);
    Messenger modify(T t);
}
