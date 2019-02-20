package com.itlbv.routines.model;

import java.time.LocalDateTime;

public class Routine extends AbstractBaseEntity {

    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime timeOfDay;
    private boolean active;

    public Routine(Integer id, String name, String description, LocalDateTime startTime, LocalDateTime endTime, LocalDateTime timeOfDay) {
        super(id, name);
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeOfDay = timeOfDay;
        this.active = true;
    }
}
