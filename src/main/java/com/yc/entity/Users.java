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
    @Column(name = "usertype", nullable = true)
    private Integer usertype;
    @Basic
    @Column(name = "fullname", nullable = true, length = 45)
    private String fullname;
    @Basic
    @Column(name = "email", nullable = true, length = 45)
    private String email;
    @Basic
    @Column(name = "phone", nullable = true, length = 15)
    private String phone;
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

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        return Objects.equals(username, users.username) && Objects.equals(password, users.password) && Objects.equals(usertype, users.usertype) && Objects.equals(fullname, users.fullname) && Objects.equals(email, users.email) && Objects.equals(phone, users.phone) && Objects.equals(role, users.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, usertype, fullname, email, phone, role);
    }
}
