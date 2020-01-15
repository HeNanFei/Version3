package com.zjt.manager.service.serviceimpl;

import com.zjt.manager.mapper.TeacherMapper;
import com.zjt.manager.pojo.Teacher;
import com.zjt.manager.pojo.TeacherExample;
import com.zjt.manager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> listTeacher() {

        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTidIsNotNull();

        return teacherMapper.selectByExample(teacherExample);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    @Override
    public Teacher findTeacherByName(String tname) {

        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTnameEqualTo(tname);
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        return teachers.get(0);
    }
}
