package jdbc_crud_with_statements.service;

import java.util.List;

import jdbc_crud_with_statements.dao.CustomerDao;
import jdbc_crud_with_statements.dto.Customer;

public class CustomerService {
	CustomerDao dao=new CustomerDao();
	
	//insert
	public void insertCustomer(Customer customer) {
		if(customer.getCustomerId()>0) {
			dao.insertCustomer(customer);
		}
		
	}
	
	//update
	public void updateName(String name, int id) {
		int id1=dao.getById(id);
		if(id==id1) {
			dao.updateName(name, id1);
		}
		else {
			System.out.println("id is not present");
		}
	}
	
	
	public void updateEmail(String email, int id) {
		int id1=dao.getById(id);
		if(id==id1) {
			dao.updateEmail(email, id1);
			
		}
		else {
			System.out.println("id is not present");
		}
	}
	
	
	//delete
	public void deleteCutomer(Customer customer) {
		dao.deleteCutomer(customer);
	}
		
	//display
	public List<Customer> displayCustomer() {
		return dao.displayCustomer();
	}
	
	
}
