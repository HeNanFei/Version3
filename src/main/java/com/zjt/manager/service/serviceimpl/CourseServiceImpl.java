package com.zjt.manager.service.serviceimpl;

import com.zjt.manager.mapper.CourseMapper;
import com.zjt.manager.pojo.Course;
import com.zjt.manager.pojo.CourseExample;
import com.zjt.manager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> listCourse() {

        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCidIsNotNull();

        return courseMapper.selectByExample(courseExample);
    }

    @Override
    public void addCourse(Course course) {
        courseMapper.insert(course);
    }
}
