package com.itlbv.routines.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity {

    @NotEmpty
    @Column(nullable = false)
    private String email;

    @NotEmpty
    @Column(nullable = false)
    @Length(min = 6)
    private String password;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(nullable = false)
    private Role role;

    @NotEmpty
    @Column(name = "registered_time_date", nullable = false)
    private Instant registeredTimeDate;

    public User() {

    }

    public User(String name, String email, String password, Role role) {
        super(null, name);
        this.email = email;
        this.password = password;
        this.role = role;
        this.registeredTimeDate = Instant.now();
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + getId()
                + ", name=" + getName()
                + ", email=" + email
                + ", password=" + password
                + ", role=" + role
                + ", registeredTimeDate=" + registeredTimeDate + "}";
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

    public Instant getRegisteredTimeDate() {
        return registeredTimeDate;
    }

    public void setRegisteredTimeDate(Instant registeredTimeDate) {
        this.registeredTimeDate = registeredTimeDate;
    }
}
