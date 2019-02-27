package com.itlbv.routines.web;

import com.itlbv.routines.model.Routine;
import com.itlbv.routines.service.RoutineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RoutineRestController {
    private static final Logger log = LoggerFactory.getLogger(RoutineRestController.class);

    private RoutineService service;

    @Autowired
    public RoutineRestController(RoutineService routineService) {
        service = routineService;
    }

    public Routine create(Routine user) {
        log.info("create {}", user);
        // TODO check if user is new
        return service.create(user);
    }

    public void update(Routine user) {
        log.info("update {}", user);
        // TODO check id consistency
        service.update(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public Routine get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public List<Routine> getAll() {
        log.info("getAll");
        return service.getAll();
    }
}
