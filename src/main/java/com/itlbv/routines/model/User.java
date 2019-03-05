package com.itlbv.routines.model;

import java.time.Instant;

public class User extends AbstractBaseEntity {

    private String email;
    private String password;
    private Role role;
    private Instant timeDateOfRegistration;

    public User(Integer id, String name, String email, String password, Role role) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.role = role;
        this.timeDateOfRegistration = Instant.now();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Instant getTimeDateOfRegistration() {
        return timeDateOfRegistration;
    }

    public void setTimeDateOfRegistration(Instant timeDateOfRegistration) {
        this.timeDateOfRegistration = timeDateOfRegistration;
    }
}
