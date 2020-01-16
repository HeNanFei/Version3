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


    @Override
    public void insertTeacher(Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    @Override
    public List<Teacher> list() {
        TeacherExample teacherExample = new TeacherExample();

        TeacherExample.Criteria criteria = teacherExample.createCriteria();

        criteria.andTidIsNotNull();

        return teacherMapper.selectByExample(teacherExample);
    }

    @Override
    public Teacher selectTeacherByName(String teachername) {

        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTnameEqualTo(teachername);
        System.out.println("根据用户名查询的用户长度"+teacherMapper.selectByExample(teacherExample).size());
        return teacherMapper.selectByExample(teacherExample).get(0);
    }

    @Override
    public List<Teacher> getTeachersByIds(List<Integer> uids) {

        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTidIn(uids);
        return teacherMapper.selectByExample(teacherExample);
    }

    @Override
    public Teacher getById(Integer id) {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTidEqualTo(id);
        return teacherMapper.selectByExample(teacherExample).get(0);
    }

    @Override
    public void updateTeacher(Teacher teacher) {

        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTidEqualTo(teacher.getTid());
        teacherMapper.updateByExampleSelective(teacher,teacherExample);
    }

    @Override
    public void deleteTeacher(List<Integer> uids) {

        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTidIn(uids);
        teacherMapper.deleteByExample(teacherExample);
    }

   /* @Override
    public List<Teacher> selectByCriterion(Teacher teacher) {


        return teacherMapper.selectByCriteron(teacher);
    }
*/
    @Override
    public Teacher selectTeacherById(Integer uid) {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTidEqualTo(uid);

        return teacherMapper.selectByExample(teacherExample).get(0);
    }
    @Override
    public List<Teacher> selectByCriterion(String teachername) {


        return teacherMapper.selectByCriteron(teachername);
    }


}
