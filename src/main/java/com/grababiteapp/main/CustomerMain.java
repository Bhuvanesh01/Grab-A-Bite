package com.grababiteapp.main;

import java.util.Scanner;

import com.grababiteapp.model.Customer;
import com.grababiteapp.service.CustomerService;
import com.grababiteapp.service.CustomerServiceImpl;

public class CustomerMain {

	public static void main(String[] args) {
		Customer customer = new Customer();
		CustomerService service = new CustomerServiceImpl();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome ");
		System.out.println("1. Show Menu ");
		System.out.println("2. Show Profile ");
		System.out.println("3. Place Order ");
		System.out.println("4. Cancel Order ");
		System.out.println("5. Show Orders ");
		System.out.println("6. Go Back ");
		System.out.println("7. Exit ");
		System.out.println("Please Enter your Choice(1-7): ");
		int choice = input.nextInt();
		switch(choice)
		{
		case 1:
			
		case 2:
			
		case 3:
			
		case 4:
			
		case 5:
			
		case 6:
			
		case 7:
			
		default:
		}
		
		input.close();
	}

}
