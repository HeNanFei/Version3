package com.zjt.manager;



import com.zjt.manager.mapper.ScoreMapper;
import com.zjt.manager.mapper.TeacherMapper;
import com.zjt.manager.pojo.Score;
import com.zjt.manager.pojo.Teacher;
import com.zjt.manager.pojo.result.ScoreResult;
import com.zjt.manager.pojo.search.SearchCriteron;
import com.zjt.manager.service.CourseService;
import com.zjt.manager.service.ScoreService;
import com.zjt.manager.util.DateUtil;
import com.zjt.manager.util.StringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.*;

@SpringBootTest
class ManagerApplicationTests {
	@Autowired
	private ScoreMapper scoreMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private CourseService courseService;
	@Autowired
	private ScoreService scoreService;
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
	@Test
	public void test333(){
		SearchCriteron searchCriteron = new SearchCriteron();
		searchCriteron.setLimit(10);
		searchCriteron.setPage(0);
		searchCriteron.setProjectName("语文");
		List<ScoreResult> chinese = scoreMapper.selectByProject(searchCriteron);
		for(ScoreResult score:chinese){
			System.out.println("fuck"+"_____________________________"+score+chinese.size());

		}

	}
	@Test
	public void test44(){
		SearchCriteron searchCriteron = new SearchCriteron();
		searchCriteron.setCname("英语");
		searchCriteron.setSname("王子怡");


		System.out.println(searchCriteron);
		Map echartsData = scoreService.getEchartsData(searchCriteron);
		Object lnames = echartsData.get("lnames");
		System.out.println(lnames);



	}
	@Test
	public void test111(){


		List<Integer> list = new ArrayList<>();
		list.add(44);
		list.add(44);
		list.add(44);
		list.add(44);list.add(44);
		list.add(44);
		int temp = 0;
		int total = 0;
		for (int i=0;i<list.size();i++){
			temp = list.get(i);
			total+=temp;
		}
		System.out.println("slkkjdf________"+total/list.size());




	}
}
