package com.zjt.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@MapperScan("com.zjt.manager.mapper")
@SpringBootApplication
public class ManagerApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}
}
