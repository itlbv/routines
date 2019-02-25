package com.itlbv.routines.repository.mock;

import com.itlbv.routines.model.Routine;
import com.itlbv.routines.repository.RoutineRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MockRoutineRepositoryImpl implements RoutineRepository {
    private ConcurrentHashMap<Integer, Routine> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    private List<Routine> routinesForInitialPopulation = new ArrayList<>();

    {
        populateRepository();
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

    @Override
    public Routine save(Routine routine) {
        if (routine.isNew()) {
            routine.setId(counter.incrementAndGet());
            repository.put(routine.getId(), routine);
            return routine;
        }
        return repository.computeIfPresent(routine.getId(), (id, oldRoutine) -> routine);
    }

    private void populateRepository() {
        routinesForInitialPopulation.add(new Routine(1, "Routine 1", "Description 1",
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalTime.of(11, 0)));
        routinesForInitialPopulation.add(new Routine(2, "Routine 2", "Description 2",
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalTime.of(11, 0)));
        routinesForInitialPopulation.add(new Routine(3, "Routine 3", "Description 3",
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalTime.of(11, 0)));
        routinesForInitialPopulation.add(new Routine(4, "Routine 4", "Description 4",
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalTime.of(11, 0)));

        routinesForInitialPopulation.forEach(this::save);
        counter.set(repository.size());
    }
}
