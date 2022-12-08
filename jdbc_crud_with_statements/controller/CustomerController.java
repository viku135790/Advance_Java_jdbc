package jdbc_crud_with_statements.controller;
import java.util.*;

import jdbc_crud_with_statements.dto.Customer;
import jdbc_crud_with_statements.service.CustomerService;
public class CustomerController {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CustomerService customerservice=new CustomerService();
		Customer customer=new Customer();
		System.out.println("1.insert\n2.Update by id\n3.delete\n4.display");
		int ch=sc.nextInt();
		
		switch(ch) {
		case 1:{
			System.out.println("Enter the id");
			customer.setCustomerId(sc.nextInt());
			System.out.println("Enter the name");
			customer.setCustomerName(sc.next());
			System.out.println("Enter the email");
			customer.setCustomerEmail(sc.next());
			
			customerservice.insertCustomer(customer);
			
		}break;
		
		
		
		case 2:{
			System.out.println("1.Update Name\n2.Update Email");
			int x=sc.nextInt();
			switch(x) {
			case 1:{
				System.out.println("Enter the id");
				int id=sc.nextInt();
				System.out.println("Enter the name");
				String s=sc.next();
				
				customerservice.updateName(s, id);
			}break;
			case 2:{
				System.out.println("Enter the id");
				int id=sc.nextInt();
				System.out.println("Enter the email");
				String s=sc.next();
				
				customerservice.updateEmail(s, id);
			}break;
			
			}
			
		}break;
		
		
		
		case 3:{
			System.out.println("Enter the id");
			customer.setCustomerId(sc.nextInt());
			customerservice.deleteCutomer(customer);
		}break;
		
		
		
		case 4:{
			List<Customer> customers=customerservice.displayCustomer();
			for(Customer customer2 : customers) {
				System.out.println(customer2.getCustomerId());
				System.out.println(customer2.getCustomerName());
				System.out.println(customer2.getCustomerEmail());
				
				System.out.println("..........................................");
			}
			
		}break;
		
		
		
		
		case 5:{
			
			
		}
		
		
//		default:break;
		
		
		}
		
		
		
		
		
		
		
		
	}

}
