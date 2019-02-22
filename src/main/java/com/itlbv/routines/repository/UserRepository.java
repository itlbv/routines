package com.itlbv.routines.repository;

import com.itlbv.routines.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    User get(int id);

    boolean delete(int id);

    List<User> getAll();
}
