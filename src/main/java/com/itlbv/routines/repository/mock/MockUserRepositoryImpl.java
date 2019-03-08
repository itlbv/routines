package com.itlbv.routines.repository.mock;

import com.itlbv.routines.model.User;
import com.itlbv.routines.repository.UserRepository;

import java.util.List;

public class MockUserRepositoryImpl implements UserRepository {
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
