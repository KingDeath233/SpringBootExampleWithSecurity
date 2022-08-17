package com.yc.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "auth_user", schema = "spring", catalog = "")
public class AuthUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userid", nullable = false)
    private int userid;
    @Basic
    @Column(name = "username", nullable = false, length = 20)
    private String username;
    @Basic
    @Column(name = "secret", nullable = true, length = 255)
    private String secret;
    @Basic
    @Column(name = "usertype", nullable = false)
    private byte usertype;
    @Basic
    @Column(name = "lastname", nullable = true, length = 50)
    private String lastname;
    @Basic
    @Column(name = "firstname", nullable = true, length = 50)
    private String firstname;
    @Basic
    @Column(name = "phone", nullable = true, length = 50)
    private String phone;
    @Basic
    @Column(name = "email", nullable = true, length = 50)
    private String email;
    @Basic
    @Column(name = "islocked", nullable = false)
    private byte islocked;
    @Basic
    @Column(name = "createdatetime", nullable = true)
    private Timestamp createdatetime;
    @Basic
    @Column(name = "isdeleted", nullable = false)
    private byte isdeleted;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public byte getUsertype() {
        return usertype;
    }

    public void setUsertype(byte usertype) {
        this.usertype = usertype;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getIslocked() {
        return islocked;
    }

    public void setIslocked(byte islocked) {
        this.islocked = islocked;
    }

    public Timestamp getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Timestamp createdatetime) {
        this.createdatetime = createdatetime;
    }

    public byte getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(byte isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUser authUser = (AuthUser) o;
        return userid == authUser.userid && usertype == authUser.usertype && islocked == authUser.islocked && isdeleted == authUser.isdeleted && Objects.equals(username, authUser.username) && Objects.equals(secret, authUser.secret) && Objects.equals(lastname, authUser.lastname) && Objects.equals(firstname, authUser.firstname) && Objects.equals(phone, authUser.phone) && Objects.equals(email, authUser.email) && Objects.equals(createdatetime, authUser.createdatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, username, secret, usertype, lastname, firstname, phone, email, islocked, createdatetime, isdeleted);
    }
}
