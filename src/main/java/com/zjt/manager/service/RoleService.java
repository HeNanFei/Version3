package com.zjt.manager.service;

import com.zjt.manager.pojo.Role;

import java.util.List;

public interface RoleService {

    void insertRole(Integer uid, List<Integer> ridList);

    List<Role> getAllRole();
}
