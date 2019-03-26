package com.itlbv.routines.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "routines")
@NamedQueries({
        @NamedQuery(name = Routine.DELETE, query = "DELETE FROM Routine r WHERE r.id=:id"),
        @NamedQuery(name = Routine.GET_ALL, query = "SELECT r FROM Routine r")
})
public class Routine extends AbstractBaseEntity {

    public static final String DELETE = "Routine.delete";
    public static final String GET_ALL = "Routine.getAll";

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @NotEmpty
    @Column(nullable = false)
    private String description;

    @NotEmpty
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @NotEmpty
    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @NotEmpty
    @Column(name = "time_of_day", nullable = false)
    private LocalTime timeOfDay;

    @Column(nullable = false)
    private boolean active;

    public Routine() {

    }

    public Routine(String name, String description, LocalDateTime startTime, LocalDateTime endTime, LocalTime timeOfDay) {
        super(null, name);
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeOfDay = timeOfDay;
        this.active = true;
    }

    @Override
    public String toString() {
        return "Routine{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", description=" + description +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ",timeOfDay=" + timeOfDay +
                ", active=" + active + "}";
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
