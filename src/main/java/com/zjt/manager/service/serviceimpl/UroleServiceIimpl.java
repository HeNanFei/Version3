package com.zjt.manager.service.serviceimpl;

import com.zjt.manager.mapper.UroleMapper;
import com.zjt.manager.pojo.Urole;
import com.zjt.manager.service.UroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UroleServiceIimpl implements UroleService {

    @Autowired
    private UroleMapper uroleMapper;

    @Override
    public void insertURole(Integer uid, List<Integer> ridList) {
        for (Integer rid:ridList){
            Urole urole = new Urole();
            urole.setUid(uid);
            urole.setRoleid(rid);

            uroleMapper.insert(urole);
        }
    }
}
