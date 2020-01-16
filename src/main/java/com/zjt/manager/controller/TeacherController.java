package com.zjt.manager.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjt.manager.mapper.TeacherMapper;
import com.zjt.manager.pojo.Teacher;
import com.zjt.manager.service.TeacherService;
import com.zjt.manager.util.Bcry;
import com.zjt.manager.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TeacherMapper teacherMapper;

    @RequestMapping("/user/teacher/list")
    public Map listTeacher(){
        List<Teacher> list = teacherService.listTeacher();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",list);
        return map;

    }
    @RequestMapping("/user/teacher/addTeacher")
    public String addTeacher(String teacher){

        Teacher teacher1 = JSONObject.parseObject(teacher, Teacher.class);

        teacherService.addTeacher(teacher1);

        return "添加成功";

    }
    @ResponseBody
    @RequestMapping("/teacher/add")
    public String add(String teacher1){
        List<Integer> ridList = new ArrayList<>();
        Teacher teacher2 = JSONObject.parseObject(teacher1, Teacher.class);
        String type = teacher2.getType();

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

        //String password = Bcry.bcry(teacher2.getPassword());
       // teacher2.setPassword(password);
        teacher2.setType(rebuildString);
        teacherService.insertTeacher(teacher2);
        //为用户添加相关角色信息
        Teacher teacher = teacherService.selectTeacherByName(teacher2.getTname());
        Integer uid = teacher.getTid();
        //用户角色插入
        //uroleService.insertURole(uid,ridList);

        return "添加成功";
    }


    @ResponseBody
    @RequestMapping("/teacher/list")
    public Map list(Integer page,Integer limit,String teachername){
        List<Teacher> list1 = teacherMapper.selectByLimit((page-1)*limit, limit-1);
        //List<Teacher> list = teacherService.list();

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list1.size());
        if(teachername != null){
            System.out.println(teachername+"______________________"+teachername);
            Teacher teacher = new Teacher();
            teacher.setTname(teachername);
            List<Teacher> teachers = teacherService.selectByCriterion(teacher.getTname());
            for(Teacher user22 : teachers){
                user22.setType(StringUtil.transform(user22.getType()));
            }

           map.put("data",teachers);
        }else {
            System.out.println("else"+"_____________________________");
            for(Teacher user222 : list1){
                user222.setType(StringUtil.transform(user222.getType()));
            }
            map.put("data", list1);
        }
        return map;
    }



    Integer uuid;
    @ResponseBody
    @RequestMapping("/teacher/update")
    public String updateTeacher(String uid){
       uuid =  Integer.parseInt(uid);


        return "获取修改id"+uuid;
    }



    @ResponseBody
    @RequestMapping("/teacher/realUpdate")
    public String rupdateTeacher(String teacher1){
        System.out.println("拿到的uuid"+uuid);
        Teacher teacher2 = JSONObject.parseObject(teacher1, Teacher.class);
        teacher2.setTid(uuid); String type = teacher2.getType();

        String[] split = type.substring(1, type.length() - 1).split(",");
        String rebuildString ="";
        //获取用户角色标识
        for(int i=0;i<split.length;i++){
            String strings = split[i];
            String subString = strings.substring(1,strings.length()-1);

            rebuildString += subString+",";




        }
        teacher2.setType(rebuildString);
        //teacher2.setPassword(Bcry.bcry(teacher2.getPassword()));
        teacherService.updateTeacher(teacher2);

        return "修改成功";
    }

    @ResponseBody
    @RequestMapping("/teacher/delete")
    public String deleteTeacher(String ids){

        List<Integer> list = new ArrayList<>();
        String[] split = ids.split(",");

        for (int i = 0;i<split.length;i++){
            list.add(Integer.parseInt(split[i]));
        }

        teacherService.deleteTeacher(list);
        return "删除成功";
    }

    @ResponseBody
    @RequestMapping("/teacher/single")
    public Teacher tt(){

        System.out.println("tid"+"_______________"+uuid);


        return teacherService.getById(uuid);
    }

    @ResponseBody
    @RequestMapping("/teacher/deleteSingle")
    public String deleteSingle(String ids){

        List<Integer> list = new ArrayList<>();
        list.add( Integer.parseInt(ids));

        teacherService.deleteTeacher(list);
        return "删除成功";
    }



}
