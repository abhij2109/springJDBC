package com.springcore.springJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Program is getting Started...");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/springcore/springJDBC/config.xml");
        JdbcTemplate template = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
        String query="Insert into student(id,name,city) values(?,?,?)";
        int result = template.update(query,555,"Ayush Kumar","Nagpur");
        System.out.println("Numnber of result updated"+result);
    }
}

