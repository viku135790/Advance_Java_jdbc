package jdbc_preparedstatement_football.controller;

import jdbc_preparedstatement_football.dto.Football;
import jdbc_preparedstatement_football.service.FootballService;
import java.util.*;

public class FootballController {
	public static void main(String[] args) {
		Football f = new Football();
		FootballService footballService = new FootballService();
		Scanner sc = new Scanner(System.in);
		System.out.println("1.insert\n2.Update by id\n3.Delete\n4.Display\n5.Exit");
		System.out.println("Select anyone from these options");
		int ch = sc.nextInt();

		switch (ch) {
		case 1: {
			System.out.println("How much data u want to pass");
			int d=sc.nextInt();
			
			List<Football> football2=new ArrayList<Football>();
			
			
			for(int i=0; i<d; i++) {
				System.out.println("Enter the id");
				f.setId(sc.nextInt());
				System.out.println("Enter the name");
				f.setName(sc.next());
				System.out.println("Enter the score");
				f.setScore(sc.nextInt());
				System.out.println("Enter the country");
				f.setCountry(sc.next());
				System.out.println("Enter the prize");
				f.setPrize(sc.nextDouble());
				
				football2.add(f);
			}
			footballService.insertBatch(football2);

		}break;
		
		
		
		
		
		//update
		case 2:{
			System.out.println("Enter the id");
			int id=sc.nextInt();
			System.out.println("Enter the Country");
			String country=sc.next();
			System.out.println("Enter the prize");
			double prize=sc.nextDouble();
			
			footballService.updateFootball(id, country, prize);
			
		}break;
		
		
		
		
		//delete
		case 3:{
			System.out.println("Enter the id");
			int id=sc.nextInt();
			footballService.delete(id);
			
		}break;
			
		
		
		
		//display
		case 4:{
			List<Football> footballs=footballService.display();
			for (Football football : footballs) {
				System.out.println("id = "+football.getId());
				System.out.println("name = "+football.getName());
				System.out.println("score = "+football.getScore());
				System.out.println("Country = "+football.getCountry());
				System.out.println("prize = "+football.getPrize());
				
				System.out.println("================================");
			}	
			footballService.display();
			
		}
		
		
		//terminate
		case 5:{
			System.exit(0);
		}
		
		}
	}

}
