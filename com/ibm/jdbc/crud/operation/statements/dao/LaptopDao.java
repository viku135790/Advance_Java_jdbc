package com.ibm.jdbc.crud.operation.statements.dao;

/*if any program is wronge then report here 
 * https://www.linkedin.com/in/vikas-kumar-517994229/
 * */


import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibm.jdbc.crud.operation.statements.dto.Laptop;

public class LaptopDao {
	static Connection connection = null;

	public void insertLaptop(Laptop laptop) {// laptop object
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_crud_operation_statements";
			String user = "root";
			String pass = "tiger";

			connection = DriverManager.getConnection(url, user, pass);

			Statement statement = connection.createStatement();

			String insert = "insert into laptop values (" + laptop.getId() + ",'" + laptop.getName() + "',"
					+ laptop.getPrice() + ",'" + laptop.getColor() + "')";
			statement.execute(insert);

			System.out.println("data inserted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	// for update
	public void updateLaptopName(Laptop laptop) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/jdbc_crud_operation_statements";
			String user = "root";
			String pass = "tiger";

			connection = DriverManager.getConnection(url, user, pass);

			Statement statement = connection.createStatement();

			String update = "update laptop set name='" + laptop.getName() + "' where id=" + laptop.getId() + "";

			statement.executeUpdate(update);

			System.out.println("Data updated........");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	public void updateLaptopPrice(Laptop laptop) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/jdbc_crud_operation_statements";
			String user = "root";
			String pass = "tiger";

			connection = DriverManager.getConnection(url, user, pass);

			Statement statement = connection.createStatement();

			String update = "update laptop set Price=  '" + laptop.getPrice() + "'   where id=" + laptop.getId() + "";

			statement.executeUpdate(update);

			System.out.println("Data updated........");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	public void updateLaptopColor(Laptop laptop) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/jdbc_crud_operation_statements";
			String user = "root";
			String pass = "tiger";

			connection = DriverManager.getConnection(url, user, pass);

			Statement statement = connection.createStatement();

			String update = "update laptop set name='" + laptop.getColor() + "' where id=" + laptop.getId() + "";

			statement.executeUpdate(update);

			System.out.println("Data updated........");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	public void deleteLaptop(Laptop laptop) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_crud_operation_statements";
			String user = "root";
			String pass = "tiger";

			connection = DriverManager.getConnection(url, user, pass);

			Statement statement = connection.createStatement();

			String delete = "delete from laptop where id=" + laptop.getId() + "";

			statement.executeUpdate(delete);

			System.out.println("Data deleted");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}
	
	
	public List<Laptop> displayLaptop() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_crud_operation_statements";
			String user = "root";
			String pass = "tiger";

			connection = DriverManager.getConnection(url, user, pass);

			Statement statement = connection.createStatement();

			String display = "select * from laptop";

			ResultSet resultset = statement.executeQuery(display);
			
			
			
			List<Laptop> laptops= new ArrayList<Laptop>();
			while(resultset.next()) {
				Laptop laptop=new Laptop();
				laptop.setId(resultset.getInt("Id"));
				laptop.setName(resultset.getString("name"));
				laptop.setPrice(resultset.getDouble("Id"));
				laptop.setColor(resultset.getString("color"));
				
//				System.out.println("Id = "+resultset.getInt("id"));
//				System.out.println("Name = "+resultset.getString("name"));
//				System.out.println("Price = "+resultset.getDouble("price"));
//				System.out.println("Color = "+resultset.getString("color"));
				laptops.add(laptop);
			}
			return laptops;

		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;

	}

}
