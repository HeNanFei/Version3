package com.zjt.manager.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjt.manager.pojo.Teacher;
import com.zjt.manager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

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

}
