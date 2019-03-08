package com.itlbv.routines.repository;

import com.itlbv.routines.model.Routine;

import java.util.List;

public interface RoutineRepository {
    Routine save(Routine routine);

    Routine get(int id);

    boolean delete(int id);

    List<Routine> getAll();
}
