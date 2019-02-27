package com.itlbv.routines.service;

import com.itlbv.routines.model.Routine;
import com.itlbv.routines.util.NotFoundException;

import java.util.List;

public interface RoutineService {

    Routine create(Routine user);

    void update(Routine user);

    void delete(int id) throws NotFoundException;

    Routine get(int id) throws NotFoundException;

    List<Routine> getAll();
}
