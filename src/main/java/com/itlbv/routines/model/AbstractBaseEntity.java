package com.itlbv.routines.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
//http://stackoverflow.com/questions/594597/hibernate-annotations-which-is-better-field-or-property-access
@Access(AccessType.FIELD)
public abstract class AbstractBaseEntity {

    public static final int GLOBAL_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = GLOBAL_SEQ)
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
