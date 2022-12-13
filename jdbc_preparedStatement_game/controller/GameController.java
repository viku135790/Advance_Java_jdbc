package jdbc_preparedStatement_game.controller;
import java.sql.PreparedStatement;
import java.util.*;

import jdbc_preparedStatement_game.dto.Game;
import jdbc_preparedStatement_game.service.GameService;
public class GameController {
	public static void main(String[] args) {
		GameService gameService=new GameService();
		Game g=new Game();
		Scanner sc=new Scanner(System.in);
		System.out.println("1.InsertBatch\n2.Update by id\n3.Delete\n4.Display\n5.Exit");
		System.out.println("Select anyone from these options");
		int ch=sc.nextInt();
		
		switch(ch) {
		case 1:{
			System.out.println("How much details u want to pass");
			int s=sc.nextInt();
			
			List<Game> games=new ArrayList<Game>(s);
			
			for(int i=0; i<s; i++) {
				System.out.println("Enter the Game id");
				g.setId(sc.nextInt());
				System.out.println("Enter the Game name");
				g.setName(sc.next());
				System.out.println("Enter the Game score");
				g.setScore(sc.nextInt());
				System.out.println("Enter the Game price");
				g.setPrice(sc.nextDouble());
				
				games.add(g);
			}
			gameService.insertAddBatch(games);
				
		}break;
		
		
		
		case 2:{
			System.out.println("Emter the id");
			int id=sc.nextInt();
			System.out.println("Enter the name");
			String name=sc.next();
			System.out.println("Enter the price");
			double price=sc.nextDouble();
			
			gameService.updateGame(id, name, price);
		}break;
		
		
		case 3:{
			System.out.println("Enter the id");
			int id=sc.nextInt();
			gameService.deleteGame(id);
		}break;
		
		
		
		case 4:{
			List<Game> games=gameService.displayGame();
			for (Game game : games) {
				System.out.println("id = "+game.getId());
				System.out.println("name  = "+game.getName());
				System.out.println("score = "+game.getScore());
				System.out.println("price = "+game.getPrice());
				System.out.println("==========================");
			}
			gameService.displayGame();
			
		}break;
		
		
		
		case 5:{
			System.exit(0);
		}break;
				
		
		}
	}

}
