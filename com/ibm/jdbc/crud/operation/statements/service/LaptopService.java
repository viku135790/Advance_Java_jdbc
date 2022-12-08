package com.ibm.jdbc.crud.operation.statements.service;

/*if any program is wronge then report here 
 * https://www.linkedin.com/in/vikas-kumar-517994229/
 * */

import java.util.*;

import com.ibm.jdbc.crud.operation.statements.dao.LaptopDao;
import com.ibm.jdbc.crud.operation.statements.dto.Laptop;

public class LaptopService {
	
	LaptopDao dao=new LaptopDao();
	
	

	public void insertLaptop(Laptop laptop) {
		
		if(laptop.getPrice()>=40000) {
			dao.insertLaptop(laptop);
			
		}
		else {
			System.out.println("Unexpacted price");
		}
	
	}
	
	
	
	
	
	public void updateLaptopName(Laptop laptop) {
		dao.updateLaptopName(laptop);
	}
	
	
	public void updateLaptopPrice(Laptop laptop) {
		
		if(laptop.getPrice()>=40000) {
			dao.updateLaptopPrice(laptop);
		}
		else {
			System.out.println("Unexpacted price");
		}
	}
	
	public void updateLaptopColor(Laptop laptop) {
		dao.updateLaptopColor(laptop);
	}
	
	
	
	
	
	
	
	
	public void deleteLaptop(Laptop laptop) {
		dao.deleteLaptop(laptop);
	}
	
	
	
	
	
	
	
	
	
	public List<Laptop> displayLaptop() {
		// List<Laptop> laptops=dao.displayLaptop();
		 return dao.displayLaptop();
	}
	
	

}
