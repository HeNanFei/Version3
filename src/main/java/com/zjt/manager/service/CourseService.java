package com.zjt.manager.service;

import com.zjt.manager.pojo.Course;

import java.util.List;

public interface CourseService {

    List<Course> listCourse();

    void addCourse(Course course);


}
