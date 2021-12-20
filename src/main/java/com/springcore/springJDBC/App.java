package com.springcore.springJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.springJDBC.dao.StudentDao;
import com.springcore.springJDBC.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Program is getting Started...");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/springcore/springJDBC/config.xml");
        StudentDao bean = applicationContext.getBean("studentDao",StudentDao.class);
		/*
		  Student student=new Student(); 
		  student.setId(999); 
		  student.setName("John");
		  student.setCity("Lucknow");
		 */
        Student student=new Student();
        student.setId(456);
        student.setName("Sejal");
        student.setCity("Bareilly");
        int r=bean.change(student);
        System.out.println(r);
    }
}

