package com.springcore.springJDBC.dao;

import com.springcore.springJDBC.entities.Student;

public interface StudentDao {
	public int insert(Student student);
	public int change(Student student);
}
