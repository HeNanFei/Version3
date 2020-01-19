package com.zjt.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjt.manager.mapper.ScoreMapper;
import com.zjt.manager.pojo.Course;
import com.zjt.manager.pojo.Score;
import com.zjt.manager.pojo.Student;
import com.zjt.manager.pojo.Teacher;
import com.zjt.manager.service.CourseService;
import com.zjt.manager.service.ScoreService;
import com.zjt.manager.service.StudentService;
import com.zjt.manager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;


    @ResponseBody
    @RequestMapping("/score/add")
    public String add(String score1){

        Score score2 = JSONObject.parseObject(score1, Score.class);
        Student student = studentService.selectStudentByName(score2.getSname());
        score2.setSid(student.getSid());
        System.out.println("ScoreAAAAAAAAAAAAAAAA"+"__________________"+score2);
        scoreService.insertScore(score2);


        return "添加成功";
    }


    @ResponseBody
    @RequestMapping("/score/list")
    public Map list(Integer page,Integer limit,String scorename){
        List<Score> list1 = scoreMapper.selectByLimit((page-1)*limit, limit-1);
        //List<Score> list = scoreService.list();

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list1.size());
        if(scorename != null){
            System.out.println(scorename+"______________________"+scorename);
            Score score = new Score();
            score.setSname(scorename);
            List<Score> scores = scoreService.selectByCriterion(score.getSname());

            map.put("data",scores);
        }else {
            System.out.println("else"+"_____________________________");

            map.put("data", list1);
        }
        return map;
    }



    Integer uuid;
    @ResponseBody
    @RequestMapping("/score/update")
    public String updateScore(String uid){
        uuid =  Integer.parseInt(uid);


        return "获取修改id"+uuid;
    }



    @ResponseBody
    @RequestMapping("/score/realUpdate")
    public String rupdateScore(String score1){
        System.out.println("拿到的uuid"+uuid);
        Score score2 = JSONObject.parseObject(score1, Score.class);
        score2.setSid(uuid);

        scoreService.updateScore(score2);

        return "修改成功";
    }


    @ResponseBody
    @RequestMapping("/score/delete")
    public String deleteScore(String ids){

        List<Integer> list = new ArrayList<>();
        String[] split = ids.split(",");

        for (int i = 0;i<split.length;i++){
            list.add(Integer.parseInt(split[i]));
        }

        scoreService.deleteScore(list);
        return "删除成功";
    }

    @ResponseBody
    @RequestMapping("/score/single")
    public Score tt(){

        System.out.println("tid"+"_______________"+uuid);


        return scoreService.getById(uuid);
    }

    @ResponseBody
    @RequestMapping("/score/deleteSingle")
    public String deleteSingle(String ids){

        List<Integer> list = new ArrayList<>();
        list.add( Integer.parseInt(ids));

        scoreService.deleteScore(list);
        return "删除成功";
    }

    @ResponseBody
    @RequestMapping("/score/ctinfor")
    public Map deleteSingle(){
        List<Teacher> teachers = teacherService.listTeacher();
        List<Course> list = courseService.listCourse();
        Map map = new HashMap();
        map.put("teachers",teachers);
        map.put("courses",list);
        return map;
    }


}
