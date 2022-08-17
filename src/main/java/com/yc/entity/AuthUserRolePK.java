package com.yc.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AuthUserRolePK implements Serializable {
    @Column(name = "userid", nullable = false)
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    @Column(name = "roleid", nullable = false)
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleid;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUserRolePK that = (AuthUserRolePK) o;
        return userid == that.userid && roleid == that.roleid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, roleid);
    }
}
