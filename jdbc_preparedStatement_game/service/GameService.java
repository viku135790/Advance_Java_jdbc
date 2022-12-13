package jdbc_preparedStatement_game.service;

import java.util.List;

import jdbc_preparedStatement_game.dao.GameDao;
import jdbc_preparedStatement_game.dto.Game;

public class GameService {
	GameDao dao=new GameDao();
	
	public void insertAddBatch(List <Game> game) {
		dao.insertAddBatch(game);
	}
	
	
	
	
	public void updateGame(int id, String name, double price) {
		int id1=dao.getById(id);
		
		if(id1==id) {
			dao.updateGame(id1, name, price);
		}
		else {
			System.out.println("Id not found");
		}
	}
	
	
	
	public void deleteGame(int id) {
		int id1=dao.getById(id);
		
		if(id1==id) {
			dao.deleteGame(id1);
		}
		else {
			System.out.println("Id not found");
		}
	}
	
	
	
	public List<Game> displayGame(){
		return dao.displayGame();
		
	}

}
