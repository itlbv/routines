package com.itlbv.routines.service;

import com.itlbv.routines.model.Routine;
import com.itlbv.routines.repository.RoutineRepository;
import com.itlbv.routines.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineServiceImpl implements RoutineService {

    /*
    @Autowired
    RoutineRepository repository;
    */

    private final RoutineRepository repository;

    @Autowired
    public RoutineServiceImpl(RoutineRepository repository) {
        this.repository = repository;
    }

    @Override
    public Routine create(Routine user) {
        return null;
    }

    @Override
    public void update(Routine user) {
        repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        // TODO check not found
        repository.delete(id);
    }

    @Override
    public Routine get(int id) throws NotFoundException {
        // TODO check not found
        return repository.get(id);
    }

    @Override
    public List<Routine> getAll() {
        return repository.getAll();
    }
}
