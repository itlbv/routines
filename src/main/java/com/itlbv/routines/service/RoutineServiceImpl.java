package com.itlbv.routines.service;

import com.itlbv.routines.model.Routine;
import com.itlbv.routines.repository.RoutineRepository;
import com.itlbv.routines.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.itlbv.routines.util.ValidationUtil.checkNotFound;

@Service
public class RoutineServiceImpl implements RoutineService {

    private final RoutineRepository repository;

    @Autowired
    public RoutineServiceImpl(RoutineRepository repository) {
        this.repository = repository;
    }

    @Override
    public Routine create(Routine user) {
        return repository.save(user);
    }

    @Override
    public void update(Routine user) {
        checkNotFound(repository.save(user), user.getId()); //Routine
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFound(repository.delete(id), id); //boolean true if success
    }

    @Override
    public Routine get(int id) throws NotFoundException {
        return checkNotFound(repository.get(id), id); //Routine
    }

    @Override
    public List<Routine> getAll() {
        return repository.getAll();
    }
}
