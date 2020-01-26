package com.zjt.manager.controller;

import com.zjt.manager.pojo.Course;
import com.zjt.manager.pojo.Student;
import com.zjt.manager.pojo.Teacher;
import com.zjt.manager.pojo.User;
import com.zjt.manager.pojo.result.Eroll;
import com.zjt.manager.service.CourseService;
import com.zjt.manager.service.StudentService;
import com.zjt.manager.service.TeacherService;
import com.zjt.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WelcomeController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;



    @ResponseBody
    @RequestMapping("/welcome/data")
    public Map welcome(){

        Map map = new HashMap();
        List<Student> studentList  = studentService.list();

        List<User> userList = userService.list();

        List<Teacher> teacherList = teacherService.list();

        List<Course> courseList = courseService.list();

        List<String> edateList = new ArrayList<>();

        List<Integer> countList = new ArrayList<>();

        List<Eroll> eroll = studentService.getEroll();
        for(Eroll e :eroll){
            if(e.getEdate()!= null) {
                edateList.add(e.getEdate());
            }

            countList.add(e.getCount());

        }

        map.put("teacherCount",teacherList.size());
        map.put("studentCount",studentList.size());
        map.put("courseCount",courseList.size());
        map.put("userCount",userList.size());
        map.put("edateList",edateList);
        map.put("countList",countList);

        return map;
    }

}
