package com.zjt.manager.service.serviceimpl;

import com.zjt.manager.mapper.RoleMapper;
import com.zjt.manager.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void insertRole(Integer uid, List<Integer> ridList) {
        for(Integer rid :ridList){



        }
    }
}
