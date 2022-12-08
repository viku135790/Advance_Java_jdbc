package jdbc_preparedStatement_evening.service;

import java.util.List;

import jdbc_preparedStatement_evening.dao.MobileDao;
import jdbc_preparedStatement_evening.dto.Mobile;

public class MobileService {
	MobileDao dao=new MobileDao();
	
	
	//insert
	public void insertMobile(Mobile mobile) {
		dao.insertMobile(mobile);
		
	}
	
	
	
	
	//update
	public void updateMobile(int id, String color, double price) {
		int id1=dao.getById(id);
		
		
		if(id1==id) {
			dao.updateMobile(id, color, price);
		}
		else {
			System.out.println("Id not found");
		}
		
	}
	
	
	
	
	
	
	//delete
	public void deleteMobile(int id) {
		int id1=dao.getById(id);
		if(id1==id) {
			dao.deleteMobile(id);
		}
		else {
			System.out.println("id is not present in data base");
		}
	}
	
	
	
	
	
	
	
	//display
	
	public List<Mobile> displayMobile(){
		return dao.displayMobile();
	}

}
