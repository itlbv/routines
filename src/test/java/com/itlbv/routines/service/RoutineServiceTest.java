package com.itlbv.routines.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
public class RoutineServiceTest {

    @Autowired
    RoutineService service;

    @Test
    public void create() {

    }

    @Test
    public void update() {

    }

    @Test
    public void delete() {

    }

    @Test
    public void deleteNotFound() {

    }

    @Test
    public void get() {

    }

    @Test
    public void getNotFound() {

    }

    @Test
    public void getAll() {

    }
}