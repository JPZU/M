package com.macalz.macalz_backend.persistence.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id", length = 11)
    private String userId;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 250, nullable = false, unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    public User() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
