package com.zjt.manager.controller;
import com.alibaba.fastjson.JSONObject;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.scenario.effect.Identity;
import com.zjt.manager.mapper.UroleMapper;
import com.zjt.manager.mapper.UserMapper;
import com.zjt.manager.pojo.User;
import com.zjt.manager.service.UroleService;
import com.zjt.manager.service.UserService;
import com.zjt.manager.util.Bcry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UroleService uroleService;

    @ResponseBody
   @RequestMapping("/user/add")
   public String add(String user1){
       List<Integer> ridList = new ArrayList<>();
       User user2 = JSONObject.parseObject(user1, User.class);
       String type = user2.getType();

       String[] split = type.substring(1, type.length() - 1).split(",");
       String rebuildString ="";
       //获取用户角色标识
      for(int i=0;i<split.length;i++){
          String strings = split[i];
          String subString = strings.substring(1,strings.length()-1);

          rebuildString += subString+",";
        int i2 = Integer.parseInt(subString);

          ridList.add(i2);

      }
       
       String password = Bcry.bcry(user2.getPassword());
       user2.setPassword(password);
       user2.setType(rebuildString);
       userService.insertUser(user2);
       //为用户添加相关角色信息
       User user = userService.selectUserByName(user2.getUsername());
       Integer uid = user.getUid();
       //用户角色插入
       uroleService.insertURole(uid,ridList);

       return "添加成功";
   }


   @ResponseBody
   @RequestMapping("/user/list")
    public Map list(Integer page,Integer limit,String username){
       List<User> list1 = userMapper.selectByLimit((page-1)*limit, limit-1);
       List<User> list = userService.list();

       /*PageHelper.startPage(page,limit);
       List<User> list = userService.list();
       PageInfo<User> pageInfo = new PageInfo<>(list);

       List<User> list1 = pageInfo.getList();*/

       Map<String,Object> map = new HashMap<>();
       map.put("code",0);
       map.put("msg","");
       map.put("count",list.size());
       if(username != null){
           User user = new User();
           user.setUsername(username);
           List<User> users = userService.selectByCriterion(user);
           map.put("data",users);
       }else {
           map.put("data", list1);
       }
       return map;
   }



    Integer uuid = null;
    @ResponseBody
    @RequestMapping("/user/update")
    public String updateUser(String uid){
        uuid = Integer.parseInt(uid);

        return "获取修改id";
    }



    @ResponseBody
    @RequestMapping("/user/realUpdate")
    public String rupdateUser(String user1){
        System.out.println("拿到的uuid"+uuid);
        User user2 = JSONObject.parseObject(user1, User.class);
        user2.setUid(uuid);
        user2.setPassword(Bcry.bcry(user2.getPassword()));
        userService.updateUser(user2);

        return "修改成功";
    }

    @ResponseBody
    @RequestMapping("/user/delete")
    public String deleteUser(String ids){

        List<Integer> list = new ArrayList<>();
        String[] split = ids.split(",");

        for (int i = 0;i<split.length;i++){
            list.add(Integer.parseInt(split[i]));
        }

        userService.deleteUser(list);
        return "删除成功";
    }

    @ResponseBody
    @RequestMapping("/user/single")
    public User tt(){
        return userService.getById(uuid);
    }

    @ResponseBody
    @RequestMapping("/user/deleteSingle")
    public String deleteSingle(String ids){

        List<Integer> list = new ArrayList<>();
        list.add( Integer.parseInt(ids));

        userService.deleteUser(list);
        return "删除成功";
    }

}
