package com.zjt.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjt.manager.mapper.CourseMapper;
import com.zjt.manager.pojo.Course;
import com.zjt.manager.pojo.Teacher;
import com.zjt.manager.service.CourseService;
import com.zjt.manager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;
    @RequestMapping("/user/course/list")
    public Map courseList(){

        List<Course> list = courseService.listCourse();

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",list);
        return map;
    }
    @RequestMapping("/user/course/add")
    public String courseAdd(String course){
        Course course1 = JSONObject.parseObject(course, Course.class);
        Teacher teacherByName = teacherService.findTeacherByName(course1.getCtname());
        course1.setTid(teacherByName.getTid());
        courseService.addCourse(course1);
        return "添加成功";
    }

}
