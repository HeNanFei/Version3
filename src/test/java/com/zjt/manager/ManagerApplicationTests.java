package com.zjt.manager;



import com.zjt.manager.mapper.TeacherMapper;
import com.zjt.manager.pojo.Teacher;
import com.zjt.manager.service.CourseService;
import com.zjt.manager.util.StringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ManagerApplicationTests {
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private CourseService courseService;
	@Test
	void contextLoads() {

		String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
		System.out.println("密码"+hashpw);
		BCrypt.checkpw("123",hashpw);

	}
	@Test
	void test(){

		//String string = "7","1";
	}
	@Test
	public void testss(){
		Teacher teacher = new Teacher();
		teacher.setTname("何");
		List<Teacher> teachers = teacherMapper.selectByCriteron("a");

		for (Teacher teacher1 : teachers){
			System.out.println(teacher1);
		}
	}
	@Test
	public void testsss(){
		List<Teacher> su = teacherMapper.selectByCriteron("苏亚雷斯");
		for(Teacher teacher : su){
			System.out.println("su"+"___________"+teacher);
		}
	}
}
