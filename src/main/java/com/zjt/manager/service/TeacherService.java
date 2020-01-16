package com.zjt.manager.service;

import com.zjt.manager.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> listTeacher();

    void addTeacher(Teacher teacher);

    Teacher findTeacherByName(String tname);

    //窝窝头
    void insertTeacher(Teacher teacher);

    List<Teacher> list();

    Teacher selectTeacherByName(String teachername);

    List<Teacher> getTeachersByIds(List<Integer> uids);

    Teacher getById(Integer id);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(List<Integer> uids);

    //List<Teacher> selectByCriterion(Teacher teacher);

    Teacher selectTeacherById(Integer uid);

    List<Teacher> selectByCriterion(String teachername);


}
