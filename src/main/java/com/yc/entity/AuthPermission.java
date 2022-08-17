package com.yc.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "auth_permission", schema = "spring", catalog = "")
public class AuthPermission {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "permissionid", nullable = false)
    private int permissionid;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = 45)
    private String description;
    @Basic
    @Column(name = "url", nullable = false, length = 255)
    private String url;
    @Basic
    @Column(name = "status", nullable = false)
    private int status;
    @Basic
    @Column(name = "createby", nullable = true, length = 45)
    private String createby;
    @Basic
    @Column(name = "createdatetime", nullable = true)
    private Timestamp createdatetime;
    @Basic
    @Column(name = "lastupdatedby", nullable = true, length = 45)
    private String lastupdatedby;
    @Basic
    @Column(name = "lastupdatedatetime", nullable = true)
    private Timestamp lastupdatedatetime;
    @Basic
    @Column(name = "isdeleted", nullable = false)
    private byte isdeleted;

    public int getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(int permissionid) {
        this.permissionid = permissionid;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getLastupdatedby() {
        return lastupdatedby;
    }

    public void setLastupdatedby(String lastupdatedby) {
        this.lastupdatedby = lastupdatedby;
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
        AuthPermission that = (AuthPermission) o;
        return permissionid == that.permissionid && status == that.status && isdeleted == that.isdeleted && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(url, that.url) && Objects.equals(createby, that.createby) && Objects.equals(createdatetime, that.createdatetime) && Objects.equals(lastupdatedby, that.lastupdatedby) && Objects.equals(lastupdatedatetime, that.lastupdatedatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionid, name, description, url, status, createby, createdatetime, lastupdatedby, lastupdatedatetime, isdeleted);
    }
}
