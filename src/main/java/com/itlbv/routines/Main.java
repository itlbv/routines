package com.itlbv.routines;

import com.itlbv.routines.web.RoutineRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Main method Spring testing");

        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

        //RoutineRepository routineRepository = appCtx.getBean(RoutineRepository.class);
        //System.out.println(routineRepository.getAll());

        RoutineRestController controller = appCtx.getBean(RoutineRestController.class);
        System.out.println(controller.getAll());
        appCtx.close();
    }
}
