package com.itlbv.routines.repository.mock;

import com.itlbv.routines.model.Routine;
import com.itlbv.routines.repository.RoutineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MockRoutineRepositoryImpl implements RoutineRepository {
    private static final Logger log = LoggerFactory.getLogger(MockRoutineRepositoryImpl.class);

    private ConcurrentHashMap<Integer, Routine> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    private final List<Routine> routinesForInitialPopulation = new ArrayList<>();

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
        return new ArrayList<>(repository.values());
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
        log.info("repository population");
        routinesForInitialPopulation.add(new Routine("Routine 1", "Description 1",
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalTime.of(11, 0)));
        routinesForInitialPopulation.add(new Routine("Routine 2", "Description 2",
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalTime.of(11, 0)));
        routinesForInitialPopulation.add(new Routine("Routine 3", "Description 3",
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalTime.of(11, 0)));
        routinesForInitialPopulation.add(new Routine("Routine 4", "Description 4",
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalDateTime.of(2019, Month.FEBRUARY, 20, 10, 0),
                LocalTime.of(11, 0)));

        routinesForInitialPopulation.forEach(this::save);
    }
}
