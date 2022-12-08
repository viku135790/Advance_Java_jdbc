package jdbc_preparedStatement_car.controller;

import java.util.*;

import jdbc_preparedStatement_car.dao.CarDao;
import jdbc_preparedStatement_car.dto.Car;
import jdbc_preparedStatement_car.service.CarService;

public class CarController {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		CarService carService=new CarService();
		CarDao dao=new CarDao();
		Car car=new Car();
		System.out.println("1.insert\n2.Update by id\n3.delete\n4.display\n5.Terminate");
		int ch=sc.nextInt();
		
		
		//for insert---------------------------------------------------------------------
		switch(ch) {
		case 1:{
				System.out.println("How much data u want to enter ");
				int x=sc.nextInt();
				while(x>0) {
					System.out.println("Enter car id");
					car.setId(sc.nextInt());
					System.out.println("Enter the car name");
					car.setName(sc.next());
					System.out.println("Enter the car color");
					car.setColor(sc.next());
					System.out.println("Enter the car price");
					car.setPrice(sc.nextDouble());
					
					carService.insertCar(car);
					
					x--;
				}
		}break;
		
		
		
		
		
		
		
		//for update--------------------------------------------------------------------------
		case 2:{
			System.out.println("1.ColorUpdate\n2.PriceUpdate\n5.Terminate");
			System.out.println("Select anyone from these option");
			
			int u=sc.nextInt();
			switch(u) {
			case 1:{
				System.out.println("Enter the id");
				int id=sc.nextInt();
				System.out.println("Enter the new Color");
				String color=sc.next();
				
				carService.updateColor(id, color);
			}break;
			
			case 2:{
				System.out.println("Enter the id");
				int id=sc.nextInt();
				System.out.println("Enter the new Price");
				double price=sc.nextDouble();
				
				carService.updatePrice(id, price);
			}break;
			
			case 5:{
				System.exit(0);
			}break;
			
			}
		}break;
		
		
		
		//delete---------------------------------------------------------------------------
		case 3:{
			System.out.println("Enter the id");
			int id=sc.nextInt();
			carService.deleteCar(id);
			
		}break;
		
		
		
		
		
		//display--------------------------------------------------------------------------
		case 4:{
			List<Car> cars=carService.displayCar();
			for (Car car2 : cars) {
				System.out.println("id = "+car2.getId());
				System.out.println("name = "+car2.getName());
				System.out.println("color = "+car2.getColor());
				System.out.println("price = "+car2.getPrice());
				System.out.println("=========================");
			}
			carService.displayCar();
		}
		
		
		//for terminate----------------------------------------------------------------------
		case 5:{
			System.exit(0);
		}
		}
	}

}

