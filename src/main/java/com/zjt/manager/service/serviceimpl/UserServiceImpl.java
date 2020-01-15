package com.zjt.manager.service.serviceimpl;

import com.zjt.manager.mapper.UserMapper;
import com.zjt.manager.pojo.User;
import com.zjt.manager.pojo.UserExample;
import com.zjt.manager.service.UserService;
import javafx.scene.shape.Circle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;


    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> list() {
        UserExample userExample = new UserExample();

        UserExample.Criteria criteria = userExample.createCriteria();

        criteria.andUidIsNotNull();

        return userMapper.selectByExample(userExample);
    }

    @Override
    public User selectUserByName(String username) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        System.out.println("根据用户名查询的用户长度"+userMapper.selectByExample(userExample).size());
        return userMapper.selectByExample(userExample).get(0);
    }

    @Override
    public List<User> getUsersByIds(List<Integer> uids) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUidIn(uids);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public User getById(Integer id) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUidEqualTo(id);
        return userMapper.selectByExample(userExample).get(0);
    }

    @Override
    public void updateUser(User user) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUidEqualTo(user.getUid());
        userMapper.updateByExampleSelective(user,userExample);
    }

    @Override
    public void deleteUser(List<Integer> uids) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUidIn(uids);
        userMapper.deleteByExample(userExample);
    }


}
