package jdbc_crud_with_statements.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc_crud_with_statements.dto.Customer;
import java.util.*;

public class CustomerDao {
	static Connection connection=null;
	public void insertCustomer(Customer customer) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//fully verified name of driver class
			String url="jdbc:mysql://localhost:3306/jdbc_crud_with_statement";
			String user="root";
			String pass="tiger";
			
			connection=DriverManager.getConnection(url, user, pass);
			Statement statement=connection.createStatement();
			
			String insert="insert into Customer values("+customer.getCustomerId()+", '"+customer.getCustomerName()+"', '"+customer.getCustomerEmail()+"')";
			
			statement.execute(insert);
			
			System.out.println("data inserted......");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	//updateName
	public void updateName(String name, int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/jdbc_crud_with_statement";
			String user="root";
			String pass="tiger";
			connection=DriverManager.getConnection(url, user, pass);
			
			Statement statement=connection.createStatement();
			
			String update="update customer set name='"+name+"' where id="+id+" ";
			statement.executeUpdate(update);
			
			System.out.println("Data updated sucessfully");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateEmail(String email, int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/jdbc_crud_with_statement";
			String user="root";
			String pass="tiger";
			connection=DriverManager.getConnection(url, user, pass);
			
			Statement statement=connection.createStatement();
			
			String update="update customer set email='"+email+"' where id="+id+" ";
			statement.executeUpdate(update);
			
			System.out.println("Data updated sucessfully");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public void deleteCutomer(Customer customer) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/jdbc_crud_with_statement";
			String user="root";
			String pass="tiger";
			connection=DriverManager.getConnection(url, user, pass);
			
			Statement statement=connection.createStatement();
			
			String delete="delete from customer where id="+customer.getCustomerId()+" ";
			statement.executeUpdate(delete);
			
			System.out.println("Data deleted sucessfully");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//for display
	public List<Customer> displayCustomer() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/jdbc_crud_with_statement";
			String user="root";
			String pass="tiger";
			connection=DriverManager.getConnection(url, user, pass);
			
			Statement statement=connection.createStatement();
			
			String display="select * from customer";
			ResultSet resultSet= statement.executeQuery(display);
			
			List<Customer> customers=new ArrayList<Customer>();
			while(resultSet.next()) {
				Customer customer=new Customer();
				customer.setCustomerId(resultSet.getInt("id"));
				customer.setCustomerName(resultSet.getString("Name"));
				customer.setCustomerEmail(resultSet.getString("email"));
				
				customers.add(customer);
			}
			
			return customers;
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	//get by id for validation
	public int getById(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/jdbc_crud_with_statement";
			String user="root";
			String pass="tiger";
			connection=DriverManager.getConnection(url, user, pass);
			
			Statement statement=connection.createStatement();
			
			String displayId ="select * from customer where id="+id+" ";
			ResultSet resultset=statement.executeQuery(displayId);
			
			resultset.next();
			try {
				int id1=resultset.getInt("id");
				return id1;
			}catch (Exception e) {
				System.out.println("Id is not found");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
