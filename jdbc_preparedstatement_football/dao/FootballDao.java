package jdbc_preparedstatement_football.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_preparedstatement_football.connection.FootballConnection;
import jdbc_preparedstatement_football.dto.Football;

public class FootballDao {
	static Connection connection=null;
	public void insertBatch(List<Football>football) {
		connection=FootballConnection.getConnection();
		String insert="insert into football values(?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			for (Football football2 : football) {
				preparedStatement.setInt(1, football2.getId());
				preparedStatement.setString(2, football2.getName());
				preparedStatement.setInt(3, football2.getScore());
				preparedStatement.setString(4, football2.getCountry());
				preparedStatement.setDouble(5, football2.getPrize());
				
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			System.out.println("data Inserted.........");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	//update
	public void updateFootball(int id, String country, double prize) {
		connection=FootballConnection.getConnection();
		String update="update football set country=?, prize=? where id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(update);
			preparedStatement.setInt(3, id);
			preparedStatement.setString(1, country);
			preparedStatement.setDouble(2, prize);
			
			preparedStatement.executeUpdate();
			System.out.println("Data updated...............");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	//getbyid
	
	public int getById(int id) {
		connection=FootballConnection.getConnection();
		String dsplid="select * from football where id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(dsplid);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				if(resultSet!= null) {
					int id1=resultSet.getInt("id");
					System.out.println("Id found = "+ id1);
					return id1;
				}
				else {
					return 0;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
	
	
	
	//delete
	public void delete(int id) {
		connection=FootballConnection.getConnection();
		String delete="delete from football where id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(delete);
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
			
			System.out.println("data deleted...............");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	//display
	public List<Football> display() {
		connection=FootballConnection.getConnection();
		String display="Select * from football";
		
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(display);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			List<Football> footballs=new ArrayList<Football>();
			while(resultSet.next()) {
				Football f=new Football();
				f.setId(resultSet.getInt("id"));
				f.setName(resultSet.getString("name"));
				f.setScore(resultSet.getInt("score"));
				f.setCountry(resultSet.getString("country"));
				f.setPrize(resultSet.getDouble("prize"));
				
				footballs.add(f);
			}
			return footballs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
