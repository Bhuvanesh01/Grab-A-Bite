package com.grababiteapp.accounts;

import java.util.Scanner;
import com.grababiteapp.exception.UserAlreadyPresentException;
import com.grababiteapp.model.Customer;
import com.grababiteapp.model.Restaurant;
import com.grababiteapp.service.CustomerService;
import com.grababiteapp.service.CustomerServiceImpl;
import com.grababiteapp.service.RestaurantService;
import com.grababiteapp.service.RestaurantServiceImpl;

public class Signup {

	public void customerSignup() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name :");
		String name = sc.nextLine();
		System.out.println("Enter Email :");
		String email = sc.nextLine();
		System.out.println("Enter Password :");
		String password = sc.nextLine();
		System.out.println("Enter Phone Number :");
		int phone = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Address :");
		String address = sc.nextLine();
		Customer custDetails = new Customer(name, email, password, phone, address);
		CustomerService cust = new CustomerServiceImpl();
		int result = 1;
		try {
			result = cust.checkAlreadyRegistered(email);
		} catch (UserAlreadyPresentException e) {
			System.out.println(e.getMessage());
		}
		if (result == 0) {
			cust.customerSignup(custDetails);
		}
		sc.close();
	}

	public void restaurantSignup() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name :");
		String name = sc.nextLine();
		System.out.println("Enter Email :");
		String email = sc.nextLine();
		System.out.println("Enter Password :");
		String password = sc.nextLine();
		System.out.println("Enter Phone Number :");
		int phone = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Address :");
		String address = sc.nextLine();
		Restaurant restDetails = new Restaurant(name, email, password, phone, address);
		RestaurantService rest = new RestaurantServiceImpl();
		int result = 1;
		try {
			result = rest.checkAlreadyRegistered(email);
		} catch (UserAlreadyPresentException e) {
			System.out.println(e.getMessage());
		}
		if (result == 0) {
			rest.restaurantSignup(restDetails);
		}
		sc.close();
	}
}
