package com_jdbc_callable_statement.service;

import java.util.List;

import com_jdbc_callable_statement.dao.StudentDao;
import com_jdbc_callable_statement.dto.Student;

public class StudentService {
	
	StudentDao studentDao=new StudentDao();
	
	public void insert(Student student) {
		studentDao.insert(student);
	}
	
	public List<Student> displayStudent() {
		return studentDao.displayStudent();
	}

}
