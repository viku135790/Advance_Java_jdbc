package jdbc_preparedstatement_football.service;

import java.util.List;

import jdbc_preparedstatement_football.dao.FootballDao;
import jdbc_preparedstatement_football.dto.Football;

public class FootballService {
	FootballDao footballDao=new FootballDao();
	public void insertBatch(List<Football>football) {
		footballDao.insertBatch(football);
	}
	
	
	
	
	
	//update
	public void updateFootball(int id, String country, double prize) {
		int id1=footballDao.getById(id);
		
		if(id==id1) {
			footballDao.updateFootball(id1, country, prize);
		}
		else {
			System.out.println("id not found");
		}
	}
	
	
	
	
	//delete
	public void delete(int id) {
		int id1=footballDao.getById(id);
		if(id==id1) {
			footballDao.delete(id1);
		}
		else {
			System.out.println("id not found");
		}
	}
	
	public List<Football> display() {
		return footballDao.display();
	}

}
