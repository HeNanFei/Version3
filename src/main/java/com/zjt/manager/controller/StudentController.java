package com.zjt.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjt.manager.mapper.StudentMapper;
import com.zjt.manager.pojo.Student;
import com.zjt.manager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentMapper studentMapper;


    @ResponseBody
    @RequestMapping("/student/add")
    public String add(String student1){

        Student student2 = JSONObject.parseObject(student1, Student.class);

        studentService.insertStudent(student2);


        return "添加成功";
    }


    @ResponseBody
    @RequestMapping("/student/list")
    public Map list(Integer page,Integer limit,String studentname){
        List<Student> list1 = studentMapper.selectByLimit((page-1)*limit, limit-1);
        List<Student> list = studentService.list();

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        if(studentname != null){
            System.out.println(studentname+"______________________"+studentname);
            Student student = new Student();
            student.setSname(studentname);
            List<Student> students = studentService.selectByCriterion(student.getSname());

            map.put("data",students);
        }else {
            System.out.println("else"+"_____________________________");

            map.put("data", list1);
        }
        return map;
    }



    Integer uuid;
    @ResponseBody
    @RequestMapping("/student/update")
    public String updateStudent(String uid){
        uuid =  Integer.parseInt(uid);


        return "获取修改id"+uuid;
    }



    @ResponseBody
    @RequestMapping("/student/realUpdate")
    public String rupdateStudent(String student1){
        System.out.println("拿到的uuid"+uuid);
        Student student2 = JSONObject.parseObject(student1, Student.class);
        student2.setSid(uuid);

        studentService.updateStudent(student2);

        return "修改成功";
    }


    @ResponseBody
    @RequestMapping("/student/delete")
    public String deleteStudent(String ids){

        List<Integer> list = new ArrayList<>();
        String[] split = ids.split(",");

        for (int i = 0;i<split.length;i++){
            list.add(Integer.parseInt(split[i]));
        }

        studentService.deleteStudent(list);
        return "删除成功";
    }

    @ResponseBody
    @RequestMapping("/student/single")
    public Student tt(){

        System.out.println("tid"+"_______________"+uuid);


        return studentService.getById(uuid);
    }

    @ResponseBody
    @RequestMapping("/student/deleteSingle")
    public String deleteSingle(String ids){

        List<Integer> list = new ArrayList<>();
        list.add( Integer.parseInt(ids));

        studentService.deleteStudent(list);
        return "删除成功";
    }


}
