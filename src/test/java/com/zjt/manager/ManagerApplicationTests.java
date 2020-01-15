package com.zjt.manager;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
class ManagerApplicationTests {

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

}
