package jdbc_preparedStatement_car.service;

import java.util.List;

import jdbc_preparedStatement_car.dao.CarDao;
import jdbc_preparedStatement_car.dto.Car;

public class CarService {
	CarDao dao=new CarDao();
	public void insertCar(Car car) {
		dao.insertCar(car);
	}
	
	
	
	
	
	
	
	//update color
	public void updateColor(int id, String color) {
		int id1=dao.getById(id);
		
		if(id1==id) {
			dao.updateColor(id1, color);
			
		}
		else {
			System.out.println("Id not matched");
		}
	}
	
	//for price update
	public void updatePrice(int id, Double price) {
		int id1=dao.getById(id);
		if(id1==id) {
			dao.updatePrice(id, price);
		}
		else {
			System.out.println("id not matched");
		}
	}
	
	
	
	
	
	
	
	//for delete
	public void deleteCar(int id) {
		int id1=dao.getById(id);
		if(id1==id) {
			dao.deleteCar(id);
		}
		else {
			System.out.println("id not esixt");
		}
		
	}
	
	
	
	
	
	
	
	
	
	//for display
	public List<Car> displayCar() {
		return dao.displayCar();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

