package com.yc.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AuthRolePermissionPK implements Serializable {
    @Column(name = "roleid", nullable = false)
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleid;
    @Column(name = "permissionid", nullable = false)
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permissionid;

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(int permissionid) {
        this.permissionid = permissionid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthRolePermissionPK that = (AuthRolePermissionPK) o;
        return roleid == that.roleid && permissionid == that.permissionid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleid, permissionid);
    }
}
