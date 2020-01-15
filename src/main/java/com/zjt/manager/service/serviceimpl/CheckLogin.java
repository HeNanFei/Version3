package com.zjt.manager.service.serviceimpl;

import com.zjt.manager.mapper.UserMapper;
import com.zjt.manager.pojo.User;
import com.zjt.manager.pojo.UserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.List;

@Service
public class CheckLogin implements UserDetailsService {
    Logger logger = LoggerFactory.getLogger(CheckLogin.class);


    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.debug("loadByName__________"+s);
       /* UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(s);
        List<User> users = userMapper.selectByExample(userExample);*/

        final User users = userMapper.getUserByName(s);
        logger.debug("users list length_________________"+users);


            UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(users.getUsername()).password(users.getPassword()).authorities(users.getType()).build();


        return userDetails;
    }
}
