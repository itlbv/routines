package com.itlbv.routines.repository.mock;

import com.itlbv.routines.model.Routine;
import com.itlbv.routines.repository.RoutineRepository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MockRoutineRepositoryImpl implements RoutineRepository {
    private ConcurrentHashMap<Integer, Routine> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public Routine save(Routine user) {
        return null;
    }

    @Override
    public Routine get(int id) {
        return repository.get(id);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public List<Routine> getAll() {
        return null;
    }
}
