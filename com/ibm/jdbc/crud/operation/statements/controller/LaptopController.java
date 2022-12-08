package com.ibm.jdbc.crud.operation.statements.controller;

/*if any program is wronge then report here 
 * https://www.linkedin.com/in/vikas-kumar-517994229/
 * */


import java.util.*;
import java.util.Scanner;

import com.ibm.jdbc.crud.operation.statements.dto.Laptop;
import com.ibm.jdbc.crud.operation.statements.service.LaptopService;

public class LaptopController {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Laptop laptop=new Laptop();
		LaptopService laptopservice=new LaptopService();
		
//		boolean b=true;
		while(true) {
			System.out.println("Choose your choice");
			System.out.println("1.insert\n2.Update\n3.delete\n4.display\n5.For exit");
			

			int ch = sc.nextInt();

			switch (ch) {
			case 1: {
				System.out.println("Enter the laptop number");
				laptop.setId(sc.nextInt());
				System.out.println("Enter the name");
				laptop.setName(sc.next());
				System.out.println("Enter the laptop price");
				laptop.setPrice(sc.nextDouble());
				System.out.println("Enter the laptop color");
				laptop.setColor(sc.next());
				
				laptopservice.insertLaptop(laptop);
				
			}break;
			
			
			
			//update laptop
			case 2: {
				System.out.println("Enter your choice ");
				System.out.println("1.update name\n2.update price\n3.update color\n4.return");
				
				switch(sc.nextInt()) {
				
				case 1:{
					System.out.println("Enter the id");
					laptop.setId(sc.nextInt());
					System.out.println("Enter the new name");
					laptop.setName(sc.next());
					laptopservice.updateLaptopName(laptop);
				}break;
				
				
				case 2:{
					System.out.println("Enter the id");
					laptop.setId(sc.nextInt());
					System.out.println("Enter the updated price");
					laptop.setPrice(sc.nextDouble());
					laptopservice.updateLaptopPrice(laptop);
				}break;
				
				
				case 3:{
					System.out.println("Enter the id");
					laptop.setId(sc.nextInt());
					System.out.println("Enter the updated color name");
					laptop.setColor(sc.next());
					laptopservice.updateLaptopColor(laptop);
				}break;
				
				}
			}break;
			
			
			
			//delete laptop
			case 3: {
				System.out.println("Enter the id");
				laptop.setId(sc.nextInt());
				laptopservice.deleteLaptop(laptop);
			}break;
			
			
			
			
			
			
			case 4:{
				List<Laptop> laptops=laptopservice.displayLaptop();
				for(Laptop laptop2 : laptops ) {
//					System.out.println(laptop2.getId());
//					System.out.println(laptop2.getName());
//					System.out.println(laptop2.getPrice());
//					System.out.println(laptop2.getColor());
					
					System.out.println(laptop2);
					System.out.println("................................");
				}
			}break;
			
			
			
			
			
			
			
			
			case 5: {
				System.exit(0);
				
			}break;
			
			
			default:break;
			}
//			b=false;
		}

	}

}
