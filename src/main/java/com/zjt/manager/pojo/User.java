package com.zjt.manager.pojo;

import java.util.List;

public class User {
    private Integer uid;

    private String username;

    private String password;

    private String type;

    private List<Urole> uroleList;

    public List<Urole> getUroleList() {
        return uroleList;
    }

    public void setUroleList(List<Urole> uroleList) {
        this.uroleList = uroleList;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}