package jdbc_preparedStatement_evening.dao;

import java.sql.Connection;
import java.util.*;

import javax.naming.PartialResultException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc_preparedStatement_evening.connection.MobileConnection;
import jdbc_preparedStatement_evening.dto.Mobile;

public class MobileDao {
	static Connection connection=null;
	public void insertMobile(Mobile mobile) {
		
		connection=MobileConnection.getConnection();
		
		String in="insert into mobile values(?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(in);
			preparedStatement.setInt(1, mobile.getId());
			preparedStatement.setString(2, mobile.getBrand());
			preparedStatement.setDouble(3, mobile.getPrice());
			preparedStatement.setString(4, mobile.getColor());
			preparedStatement.setString(5, mobile.getCamera());
			
			preparedStatement.execute();
			
			System.out.println("data inserted.............");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	//UPDATE
	
	
	public void updateMobile(int id, String color, double price) {
		     connection=MobileConnection.getConnection();
		     
		     String update = "update mobile set Color=?, Price=? where Id=?";
		try {
			
			PreparedStatement preparedStatement=connection.prepareStatement(update);
			preparedStatement.setInt(3, id);
			preparedStatement.setString(1, color);
			preparedStatement.setDouble(2, price);
			
			preparedStatement.executeUpdate();
			
			System.out.println("Data updated sucessfully ...........");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//delete
	public void deleteMobile(int id) {
		connection=MobileConnection.getConnection();
		String delete="delete from mobile where id =?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(delete);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
			System.out.println("data delete........");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	//display
	public List<Mobile> displayMobile(){
		connection=MobileConnection.getConnection();
		String display="select * from mobile";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(display);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			List<Mobile> mobilee=new ArrayList<Mobile>();
			
			while(resultSet.next()) {
				Mobile mobile=new Mobile();
				mobile.setId(resultSet.getInt("id"));
				mobile.setBrand(resultSet.getString("Brand"));
				mobile.setPrice(resultSet.getDouble("price"));
				mobile.setColor(resultSet.getString("color"));
				mobile.setCamera(resultSet.getString("camera"));
				
				mobilee.add(mobile);
			}
			return mobilee;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
	
	//get by id
	public int getById(int id) {
		connection=MobileConnection.getConnection();
		String displayid="select * from mobile where id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(displayid);
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				if(resultSet!=null) {
					int id1=resultSet.getInt("id");
					System.out.println("id found = "+id1);
					return id1;
				}
				else{
					return 0;
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	
	
	

}
