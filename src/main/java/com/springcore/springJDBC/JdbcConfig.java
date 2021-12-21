package com.springcore.springJDBC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springcore.springJDBC.dao.StudentDao;
import com.springcore.springJDBC.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages= {"com.springcore.springJDBC.dao"})
public class JdbcConfig {

	@Bean(name={"ds"})
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Abhi@2109");
		return ds;
	}
	
	@Bean(name={"jdbcTemplate"})
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean(name={"studentDao"})
	public StudentDao getStudentDao()
	{
		StudentDaoImpl studentDao=new StudentDaoImpl();
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;
	}
}
