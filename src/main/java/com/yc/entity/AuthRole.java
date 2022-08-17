package com.yc.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "auth_role", schema = "spring", catalog = "")
public class AuthRole {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "roleid", nullable = false)
    private int roleid;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = 45)
    private String description;
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

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        AuthRole authRole = (AuthRole) o;
        return roleid == authRole.roleid && isdeleted == authRole.isdeleted && Objects.equals(name, authRole.name) && Objects.equals(description, authRole.description) && Objects.equals(createby, authRole.createby) && Objects.equals(createdatetime, authRole.createdatetime) && Objects.equals(lastupdateby, authRole.lastupdateby) && Objects.equals(lastupdatedatetime, authRole.lastupdatedatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleid, name, description, createby, createdatetime, lastupdateby, lastupdatedatetime, isdeleted);
    }
}
