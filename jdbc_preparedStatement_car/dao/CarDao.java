package jdbc_preparedStatement_car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import jdbc_preparedStatement_car.connection.CarConnection;
import jdbc_preparedStatement_car.dto.Car;

public class CarDao {
	static Connection connection=null;
	public void insertCar(Car car) {
		connection=CarConnection.getConnection();
		String insert="insert into car values (?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setInt(1, car.getId());
			preparedStatement.setString(2, car.getName());
			preparedStatement.setString(3, car.getColor());
			preparedStatement.setDouble(4, car.getPrice());
			
			preparedStatement.execute();
			
			
			System.out.println("Data stored sucessfully........\nthanking you");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	
	//update car color
	public void updateColor(int id, String color) {
		connection=CarConnection.getConnection();
		String update="update car set color=? where id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(update);
			preparedStatement.setInt(2, id);
			preparedStatement.setString(1, color);
			
			preparedStatement.executeUpdate();
			System.out.println("Color updated Sucessfully........");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	//update car price
	public void updatePrice(int id, double price) {
		connection=CarConnection.getConnection();
		String update="update car set price =? where id =?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(update);
			preparedStatement.setInt(2, id);
			preparedStatement.setDouble(1, price);
			
			preparedStatement.executeUpdate();
			
			System.out.println("Price updated Sucessfully...........");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	
	//delete car
	
	public void deleteCar(int id) {
		connection=CarConnection.getConnection();
		
		String delete="delete from car where id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(delete);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
			System.out.println("Data deleted sucessfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	//display
	public List<Car> displayCar() {
		connection=CarConnection.getConnection();
		String display="select * from car";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(display);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			List<Car> cars=new ArrayList<Car>();
			
			while(resultSet.next()){
				Car c= new Car();
				c.setId(resultSet.getInt("id"));
				c.setName(resultSet.getString("name"));
				c.setColor(resultSet.getString("Color"));
				c.setPrice(resultSet.getDouble("Price"));
				
				cars.add(c);
			}
			return cars;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	
	//get by id 
	public int getById(int id) {
		connection=CarConnection.getConnection();
		String getid="select * from car where id =?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(getid);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				if(resultSet!=null) {
					int id1=resultSet.getInt("id");
					System.out.println("id found = "+id1);
					return id1;
				}
				else {
					return 0;
				}
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
		
	}
}


