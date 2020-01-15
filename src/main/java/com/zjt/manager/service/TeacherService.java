package com.zjt.manager.service;

import com.zjt.manager.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> listTeacher();

    void addTeacher(Teacher teacher);

    Teacher findTeacherByName(String tname);

}
