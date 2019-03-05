package com.itlbv.routines.model;

public abstract class AbstractBaseEntity {
    private Integer id;
    private String name;

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
