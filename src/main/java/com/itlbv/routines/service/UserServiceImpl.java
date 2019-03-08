package com.itlbv.routines.service;

import com.itlbv.routines.model.User;
import com.itlbv.routines.repository.UserRepository;
import com.itlbv.routines.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.itlbv.routines.util.ValidationUtil.checkNotFound;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public void update(User user) throws NotFoundException {
        checkNotFound(repository.save(user), user.getId());
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFound(repository.delete(id), id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return checkNotFound(repository.get(id), id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return checkNotFound(repository.getByEmail(email), 1); //TODO rewrite checkNotFound
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}
