package com.grababiteapp.accounts;

import java.util.Scanner;

import com.grababiteapp.exception.InvalidCredentialsException;
import com.grababiteapp.service.CustomerService;
import com.grababiteapp.service.CustomerServiceImpl;
import com.grababiteapp.service.RestaurantService;
import com.grababiteapp.service.RestaurantServiceImpl;

public class Login {

	public void loginForCustomer() throws InvalidCredentialsException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email :");
		String email = sc.nextLine();
		System.out.println("Enter Password :");
		String password = sc.nextLine();
		CustomerService custService = new CustomerServiceImpl();
		int result = 0;
		try {
			result = custService.loginForCustomer(email, password);
		} catch (InvalidCredentialsException e) {
			System.out.println(e.getMessage());
			sc.close();
		}
		if (result == 0) {
			System.out.println("Login Not Successfull!!");
			loginForCustomer();
		} else {
			System.out.println("Login Successfull");
			CustomerOptions.custOptions(result);
			sc.close();
		}
	}

	public void loginForRestaurant() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email :");
		String email = sc.nextLine();
		System.out.println("Enter Password :");
		String password = sc.nextLine();
		int result = 0;
		RestaurantService restService = new RestaurantServiceImpl();
		try {
			result = restService.loginForRestaurant(email, password);
		} catch (InvalidCredentialsException e) {
			System.out.println(e.getMessage());
		}

		if (result == 0) {
			System.out.println("Login Not Successfull!");
			loginForRestaurant();
		} else {
			System.out.println("Login Successfull");
			RestaurantOptions.restOptions(result);
			sc.close();
		}
	}
}
