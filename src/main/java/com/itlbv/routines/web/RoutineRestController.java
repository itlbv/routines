package com.itlbv.routines.web;

import com.itlbv.routines.model.Routine;
import com.itlbv.routines.service.RoutineService;
import com.itlbv.routines.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RoutineRestController {
    private static final Logger log = LoggerFactory.getLogger(RoutineRestController.class);

    private final RoutineService service;

    @Autowired
    public RoutineRestController(RoutineService routineService) {
        service = routineService;
    }

    public Routine create(Routine routine) {
        ValidationUtil.checkNew(routine);
        log.info("create {}", routine);
        return service.create(routine);
    }

    public void update(Routine routine, int id) {
        ValidationUtil.checkIdConsistency(routine, id);
        log.info("update {}", routine);
        service.update(routine);
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
