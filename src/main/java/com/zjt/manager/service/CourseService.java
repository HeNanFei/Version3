package com.zjt.manager.service;

import com.zjt.manager.pojo.Course;

import java.util.List;

public interface CourseService {

    List<Course> listCourse();

    void addCourse(Course course);

    //窝窝头
    void insertCourse(Course course);

    List<Course> list();

    public Course findCourseByName(String tname);

    Course selectCourseByName(String coursename);

    List<Course> getCoursesByIds(List<Integer> uids);

    Course getById(Integer id);

    void updateCourse(Course course);

    void deleteCourse(List<Integer> uids);

    //List<Course> selectByCriterion(Course course);

    Course selectCourseById(Integer uid);

    List<Course> selectByCriterion(String coursename);

}
