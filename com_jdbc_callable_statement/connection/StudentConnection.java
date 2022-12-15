package com_jdbc_callable_statement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentConnection {
	static Connection connection=null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc-student";
			String user="root";
			String pass="tiger";
			
			connection=DriverManager.getConnection(url, user, pass);
			
			if(connection!=null) {
				return connection;
			}
			else{
				System.out.println("Check connection");
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
