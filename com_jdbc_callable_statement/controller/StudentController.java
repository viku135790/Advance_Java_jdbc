package com_jdbc_callable_statement.controller;

import java.util.*;

import com_jdbc_callable_statement.dto.Student;
import com_jdbc_callable_statement.service.StudentService;
import jdbc_preparedStatement_evening.service.MobileService;
public class StudentController {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Insert\n2.display\n3.Terminate");
		int ch=sc.nextInt();
		Student student=new Student();
		StudentService studentService=new StudentService();
		
		switch (ch) {
		case 1: {
			System.out.println("Enter the id");
			student.setId(sc.nextInt());
			System.out.println("Enter the Name");
			student.setName(sc.next());
			System.out.println("Enter the phone");
			student.setPhone(sc.nextLong());
			
			studentService.insert(student);
		}break;
		
		case 2:{
			List<Student> students=studentService.displayStudent();
				for(Student student2:students) {
					System.out.println("id = "+student2.getId());
					System.out.println("name = "+student2.getName());
					System.out.println("phone = "+student2.getPhone());
					System.out.println("=========================");
					
				}
				studentService.displayStudent();
		}break;
		
		
		
		
		case 3:{
			System.exit(0);
		}break;
		
		
		
		
		default:
			System.out.println("Invalid input");
		}
	}

}
