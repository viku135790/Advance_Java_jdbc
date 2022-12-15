package com_jdbc_callable_statement.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com_jdbc_callable_statement.connection.StudentConnection;
import com_jdbc_callable_statement.dto.Student;

public class StudentDao {
	static Connection connection=null;
	public void insert(Student student) {
		connection=StudentConnection.getConnection();
		try {
			CallableStatement callableStatement=connection.prepareCall("call insertStudent(?,?,?)");
			callableStatement.setInt(1,student.getId());
			callableStatement.setString(2, student.getName());
			callableStatement.setLong(3, student.getPhone());
		
			callableStatement.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	//display
	public List<Student> displayStudent() {
		connection=StudentConnection.getConnection();
		try {
			CallableStatement callableStatement=connection.prepareCall("call updatetudent()");
			ResultSet resultSet=callableStatement.executeQuery();
			
			List<Student> students=new ArrayList<Student>();
			
			while(resultSet.next()) {
				Student s=new Student();
				s.setId(resultSet.getInt("id"));
				s.setName(resultSet.getString("name"));
				s.setPhone(resultSet.getLong("phone"));
				
				students.add(s);
			}
			
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
