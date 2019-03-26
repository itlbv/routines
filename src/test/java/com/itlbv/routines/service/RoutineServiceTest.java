package com.itlbv.routines.service;

import com.itlbv.routines.model.Routine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static com.itlbv.routines.RoutineTestData.ROUTINE_01;
import static com.itlbv.routines.RoutineTestData.ROUTINE_01_ID;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
public class RoutineServiceTest extends AbstractServiceTest {

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
        Routine routine = service.get(ROUTINE_01_ID);
        assertThat(ROUTINE_01).isEqualToComparingFieldByField(routine);
    }

    @Test
    public void getNotFound() {

    }

    @Test
    public void getAll() {

    }
}