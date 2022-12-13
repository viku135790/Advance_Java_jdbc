package jdbc_preparedStatement_game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.crypto.spec.GCMParameterSpec;

import jdbc_preparedStatement_game.connection.GameConnection;
import jdbc_preparedStatement_game.dto.Game;

public class GameDao {
	static Connection connection=null;
	
	//add batch
	public void insertAddBatch(List <Game> game) {
		connection=GameConnection.getConnection();
		String insert="insert into Game values(?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			
			for (Game  game2 : game) {
				preparedStatement.setInt(1, game2.getId());
				preparedStatement.setString(2, game2.getName());
				preparedStatement.setInt(3, game2.getScore());
				preparedStatement.setDouble(4, game2.getPrice());
				
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			System.out.println("Data inserted....................");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
				
	}
	
	
	//update-------------------------------------------------
	public void updateGame(int id, String name, double price) {
		connection=GameConnection.getConnection();
		String update="update game set price=?, name=? where id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(update);
			preparedStatement.setInt(3, id);
			preparedStatement.setString(2, name);
			preparedStatement.setDouble(1, price);
			
			preparedStatement.executeUpdate();
			
			System.out.println("Data updated......");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	//delete-----------------------------------------------
	public void deleteGame(int id) {
		connection=GameConnection.getConnection();
		
		String delete="delete from game where id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(delete);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
			System.out.println("data deleted..................");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	//display----------------------------------------------------------
	public List<Game> displayGame(){
		connection=GameConnection.getConnection();
		String display="Select * from Game";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(display);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			List<Game> games=new ArrayList<Game>();
			
			while(resultSet.next()) {
				Game g=new Game();
				g.setId(resultSet.getInt("id"));
				g.setName(resultSet.getString("name"));
				g.setScore(resultSet.getInt("score"));
				g.setPrice(resultSet.getDouble("price"));
				
				games.add(g);
			}
			return games;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	public int getById(int id) {
		connection=GameConnection.getConnection();
		String displayid="Select * from game where id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(displayid);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				if(resultSet!=null) {
					int id1=resultSet.getInt("id");
					System.out.println("Id found = "+id1);
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
