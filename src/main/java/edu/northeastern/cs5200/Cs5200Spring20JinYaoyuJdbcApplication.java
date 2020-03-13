package edu.northeastern.cs5200;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cs5200Spring20JinYaoyuJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cs5200Spring20JinYaoyuJdbcApplication.class, args);
		hw_jdbc_last_first obj = new hw_jdbc_last_first();
		obj.createDeveloper();
		obj.createWebsite();
		obj.createPage();
		obj.createWidget();
		obj.update();
	}

}
