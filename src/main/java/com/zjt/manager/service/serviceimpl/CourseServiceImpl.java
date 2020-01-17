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

   /* @Override
    public List<Course> listCourse() {

        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCidIsNotNull();

        return courseMapper.selectByExample(courseExample);
    }

    @Override
    public void addCourse(Course course) {
        courseMapper.insert(course);
    }*/

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

    @Override
    public Course findCourseByName(String tname) {

        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCnameEqualTo(tname);
        List<Course> courses = courseMapper.selectByExample(courseExample);
        return courses.get(0);
    }


    @Override
    public void insertCourse(Course course) {
        courseMapper.insert(course);
    }

    @Override
    public List<Course> list() {
        CourseExample courseExample = new CourseExample();

        CourseExample.Criteria criteria = courseExample.createCriteria();

        criteria.andCidIsNotNull();

        return courseMapper.selectByExample(courseExample);
    }

    @Override
    public Course selectCourseByName(String coursename) {

        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCnameEqualTo(coursename);
        System.out.println("根据用户名查询的用户长度"+courseMapper.selectByExample(courseExample).size());
        return courseMapper.selectByExample(courseExample).get(0);
    }

    @Override
    public List<Course> getCoursesByIds(List<Integer> uids) {

        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCidIn(uids);
        return courseMapper.selectByExample(courseExample);
    }

    @Override
    public Course getById(Integer id) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCidEqualTo(id);
        return courseMapper.selectByExample(courseExample).get(0);
    }

    @Override
    public void updateCourse(Course course) {

        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCidEqualTo(course.getCid());
        courseMapper.updateByExampleSelective(course,courseExample);
    }

    @Override
    public void deleteCourse(List<Integer> uids) {

        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCidIn(uids);
        courseMapper.deleteByExample(courseExample);
    }

    /* @Override
     public List<Course> selectByCriterion(Course course) {


         return courseMapper.selectByCriteron(course);
     }
 */
    @Override
    public Course selectCourseById(Integer uid) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCidEqualTo(uid);

        return courseMapper.selectByExample(courseExample).get(0);
    }
    @Override
    public List<Course> selectByCriterion(String coursename) {


        return courseMapper.selectByCriteron(coursename);
    }



}
