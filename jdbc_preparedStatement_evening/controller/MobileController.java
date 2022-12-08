package jdbc_preparedStatement_evening.controller;
import java.util.*;

import jdbc_preparedStatement_evening.dto.Mobile;
import jdbc_preparedStatement_evening.service.MobileService;
public class MobileController {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		MobileService mobileService=new MobileService();
		Mobile mobile=new Mobile();
		System.out.println("1.Insert\n2.Update by id\n3.Delete\n4.Display\n5.Terminate");
		System.out.println("Select anyone from these options");
		int ch=sc.nextInt();
		
		
		switch(ch) {
		case 1:{
			
				System.out.println("Enter the id");
				mobile.setId(sc.nextInt());
				System.out.println("Enter the brand");
				mobile.setBrand(sc.next());
				System.out.println("Enter the price");
				mobile.setPrice(sc.nextDouble());
				System.out.println("Enter the color");
				mobile.setColor(sc.next());
				System.out.println("Enter the camera details");
				mobile.setCamera(sc.next());
				
				mobileService.insertMobile(mobile);
				
		} 
		break;
		
		
		
		case 2:{
			System.out.println("Enter the id");
			int id=sc.nextInt();
			System.out.println("Enter the color");
			String color=sc.next();
			System.out.println("Enter the price");
			double price=sc.nextDouble();
		
			mobileService.updateMobile(id, color, price);
			
			
		}
		break;
		
		
		case 3:{
			System.out.println("Enter the id for deletation");
			int id=sc.nextInt();
			
			mobileService.deleteMobile(id);
			
	
		}break;
		
		
		
		
		//for display
		case 4:{
			List<Mobile> mobilee=mobileService.displayMobile();
			for (Mobile mobile2 : mobilee) {
				System.out.println("Id = "+mobile2.getId());
				System.out.println("Brand = "+mobile2.getBrand());
				System.out.println("Price = "+mobile2.getPrice());
				System.out.println("Color = "+mobile2.getColor());
				System.out.println("Camera = "+mobile2.getCamera());
				System.out.println("--------------------------------------");
			}
			mobileService.displayMobile();
			
	
		}break;
		case 5:{
			System.exit(0);
		}
		
		
		
		
		
		}
	}

}
