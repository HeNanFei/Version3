package com.zjt.manager.service;

import com.zjt.manager.pojo.Student;
import com.zjt.manager.pojo.result.Eroll;

import java.util.List;

public interface StudentService {
    void insertStudent(Student student);

    List<Student> list();

    Student selectStudentByName(String studentname);

    List<Student> getStudentsByIds(List<Integer> uids);

    Student getById(Integer id);

    void updateStudent(Student student);

    void deleteStudent(List<Integer> uids);

    List<Student> selectByCriterion(String sname);

    Student selectStudentById(Integer uid);


    List<Eroll> getEroll();
}
