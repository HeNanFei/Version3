package com.zjt.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjt.manager.mapper.CourseMapper;
import com.zjt.manager.pojo.Course;
import com.zjt.manager.pojo.Teacher;
import com.zjt.manager.service.CourseService;
import com.zjt.manager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private TeacherService teacherService;

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



    @ResponseBody
    @RequestMapping("/course/add")
    public String add(String course1){

        Course course2 = JSONObject.parseObject(course1, Course.class);

        courseService.insertCourse(course2);


        return "添加成功";
    }


    @ResponseBody
    @RequestMapping("/course/list")
    public Map list(Integer page,Integer limit,String coursename){
        List<Course> list1 = courseMapper.selectByLimit((page-1)*limit, limit-1);
        //List<Course> list = courseService.list();

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list1.size());
        if(coursename != null){
            System.out.println(coursename+"______________________"+coursename);
            Course course = new Course();
            course.setCname(coursename);
            List<Course> courses = courseService.selectByCriterion(coursename);

            map.put("data",courses);
        }else {
            System.out.println("else"+"_____________________________");

            map.put("data", list1);
        }
        return map;
    }



    Integer uuid;
    @ResponseBody
    @RequestMapping("/course/update")
    public String updateCourse(String uid){
        uuid =  Integer.parseInt(uid);


        return "获取修改id"+uuid;
    }



    @ResponseBody
    @RequestMapping("/course/realUpdate")
    public String rupdateCourse(String course1){
        System.out.println("拿到的uuid"+uuid);
        Course course2 = JSONObject.parseObject(course1, Course.class);
        Course courseByName = courseService.selectCourseByName(course2.getCname());
        Teacher teacher = teacherService.selectTeacherByName(course2.getCtname());
        course2.setCid(uuid);
        course2.setTid(teacher.getTid());
        courseService.updateCourse(course2);

        return "修改成功";
    }


    @ResponseBody
    @RequestMapping("/course/delete")
    public String deleteCourse(String ids){

        List<Integer> list = new ArrayList<>();
        String[] split = ids.split(",");

        for (int i = 0;i<split.length;i++){
            list.add(Integer.parseInt(split[i]));
        }
        for (Integer i:list){

            System.out.println("list Integer"+"___________________"+i);
        }
        courseService.deleteCourse(list);
        return "删除成功";
    }

    @ResponseBody
    @RequestMapping("/course/single")
    public Course tt(){

        System.out.println("tid"+"_______________"+uuid);


        return courseService.getById(uuid);
    }

    @ResponseBody
    @RequestMapping("/course/deleteSingle")
    public String deleteSingle(String ids){

        List<Integer> list = new ArrayList<>();
        list.add( Integer.parseInt(ids));

        courseService.deleteCourse(list);
        return "删除成功";
    }





}
