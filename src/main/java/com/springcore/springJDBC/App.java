package com.springcore.springJDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcore.springJDBC.dao.StudentDao;
import com.springcore.springJDBC.entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Program is getting Started...");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao bean = applicationContext.getBean("studentDao", StudentDao.class);
		// INSERT

		Student student = new Student();
		student.setId(111);
		student.setName("Mohan");
		student.setCity("Loradabad");
		int r=bean.insert(student);
		System.out.println(r);

		// UPDATE

		/*
		 * Student student=new Student(); 
		 * student.setId(456); 
		 * student.setName("Sejal");
		 * student.setCity("Bareilly"); 
		 * int r=bean.change(student);
		 * System.out.println(r);
		 */

		// DELETE

		/*
		 * int r=bean.delete(456); 
		 * System.out.println(r);
		 */

		// SELECT single object

		/*
		 * Student student=bean.getStudent(222); 
		 * System.out.println(student);
		 */

		// SELECT multiple objects

		List<Student> all = bean.getAll();
		for (Student s : all) {
			System.out.println(s);
		}
	}
}
