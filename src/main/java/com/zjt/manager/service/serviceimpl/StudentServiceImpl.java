package com.zjt.manager.service.serviceimpl;

import com.zjt.manager.mapper.StudentMapper;
import com.zjt.manager.pojo.Student;
import com.zjt.manager.pojo.StudentExample;
import com.zjt.manager.pojo.result.Eroll;
import com.zjt.manager.service.StudentService;
import com.zjt.manager.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger LOG = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public void insertStudent(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public List<Student> list() {
        StudentExample studentExample = new StudentExample();

        StudentExample.Criteria criteria = studentExample.createCriteria();

        criteria.andSidIsNotNull();

        return studentMapper.selectByExample(studentExample);
    }

    @Override
    public Student selectStudentByName(String studentname) {

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andSnameEqualTo(studentname);
        System.out.println("根据用户名查询的用户长度"+studentMapper.selectByExample(studentExample).size());
        return studentMapper.selectByExample(studentExample).get(0);
    }

    @Override
    public List<Student> getStudentsByIds(List<Integer> uids) {

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andSidIn(uids);
        return studentMapper.selectByExample(studentExample);
    }

    @Override
    public Student getById(Integer id) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andSidEqualTo(id);
        return studentMapper.selectByExample(studentExample).get(0);
    }

    @Override
    public void updateStudent(Student student) {

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andSidEqualTo(student.getSid());
        studentMapper.updateByExampleSelective(student,studentExample);
    }

    @Override
    public void deleteStudent(List<Integer> uids) {

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andSidIn(uids);
        studentMapper.deleteByExample(studentExample);
    }

    @Override
    public List<Student> selectByCriterion(String sname) {


        return studentMapper.selectByCriteron(sname);
    }

    @Override
    public Student selectStudentById(Integer uid) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andSidEqualTo(uid);

        return studentMapper.selectByExample(studentExample).get(0);
    }

    @Override
    public List<Eroll> getEroll() {
        return studentMapper.getStudentData();
    }


}
