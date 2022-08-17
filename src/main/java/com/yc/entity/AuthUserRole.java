package com.yc.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "auth_user_role", schema = "spring", catalog = "")
@IdClass(AuthUserRolePK.class)
public class AuthUserRole {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userid", nullable = false)
    private int userid;
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "roleid", nullable = false)
    private int roleid;
    @Basic
    @Column(name = "createby", nullable = true, length = 45)
    private String createby;
    @Basic
    @Column(name = "createdatetime", nullable = true)
    private Timestamp createdatetime;
    @Basic
    @Column(name = "lastupdateby", nullable = true, length = 45)
    private String lastupdateby;
    @Basic
    @Column(name = "lastupdatedatetime", nullable = true)
    private Timestamp lastupdatedatetime;
    @Basic
    @Column(name = "isdeleted", nullable = false)
    private byte isdeleted;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Timestamp getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Timestamp createdatetime) {
        this.createdatetime = createdatetime;
    }

    public String getLastupdateby() {
        return lastupdateby;
    }

    public void setLastupdateby(String lastupdateby) {
        this.lastupdateby = lastupdateby;
    }

    public Timestamp getLastupdatedatetime() {
        return lastupdatedatetime;
    }

    public void setLastupdatedatetime(Timestamp lastupdatedatetime) {
        this.lastupdatedatetime = lastupdatedatetime;
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
        AuthUserRole that = (AuthUserRole) o;
        return userid == that.userid && roleid == that.roleid && isdeleted == that.isdeleted && Objects.equals(createby, that.createby) && Objects.equals(createdatetime, that.createdatetime) && Objects.equals(lastupdateby, that.lastupdateby) && Objects.equals(lastupdatedatetime, that.lastupdatedatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, roleid, createby, createdatetime, lastupdateby, lastupdatedatetime, isdeleted);
    }
}
