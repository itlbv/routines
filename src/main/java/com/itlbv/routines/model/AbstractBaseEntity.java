package com.itlbv.routines.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractBaseEntity {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    AbstractBaseEntity() {

    }

    AbstractBaseEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isNew() {
        return (getId() == null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
