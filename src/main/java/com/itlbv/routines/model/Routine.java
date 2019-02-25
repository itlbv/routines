package com.itlbv.routines.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Routine extends AbstractBaseEntity {

    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalTime timeOfDay;
    private boolean active;

    public Routine(String name, String description, LocalDateTime startTime, LocalDateTime endTime, LocalTime timeOfDay) {
        this(null, name, description, startTime, endTime, timeOfDay);
    }

    private Routine(Integer id, String name, String description, LocalDateTime startTime, LocalDateTime endTime, LocalTime timeOfDay) {
        super(id, name);
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeOfDay = timeOfDay;
        this.active = true;
    }

    public boolean isNew() {
        return (getId() == null);
    }

    @Override
    public String toString() {
        return "Routine{" +
                "id=" + getId() +
                ", name=" + name +
                ", description=" + description +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ",timeOfDay=" + timeOfDay +
                ",active=" + active;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(LocalTime timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
