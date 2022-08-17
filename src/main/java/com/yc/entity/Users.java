package com.yc.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Users {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic
    @Column(name = "fullname", nullable = true, length = 45)
    private String fullname;
    @Basic
    @Column(name = "role", nullable = true, length = 45)
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(username, users.username) && Objects.equals(password, users.password) && Objects.equals(fullname, users.fullname) && Objects.equals(role, users.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, fullname, role);
    }
}
