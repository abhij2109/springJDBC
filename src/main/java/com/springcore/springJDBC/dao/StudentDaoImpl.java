package com.springcore.springJDBC.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springcore.springJDBC.entities.Student;

public class StudentDaoImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		String query="Insert into student(id,name,city) values(?,?,?)";
		int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}

	public int change(Student student) {
		String query="Update student set name=?,city=? where id=?";
		int r=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}

	public int delete(int id) {
		String query="Delete from student where id=?";
		int r=this.jdbcTemplate.update(query,id);
		return r;
	}

	public Student getStudent(int id) {
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query, rowMapper, id);
		return student;
	}

	public List<Student> getAll() {
		String query="select * from student";
		List<Student> students=this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}

}
