package com.grababiteapp.main;

import java.util.Scanner;

import com.grababiteapp.model.Restaurant;
import com.grababiteapp.service.RestaurantService;
import com.grababiteapp.service.RestaurantServiceImpl;

public class RestaurantMain {

	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();
		RestaurantService service = new RestaurantServiceImpl();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome ");
		System.out.println("1. Edit Menu ");
		System.out.println("2. Show Profile ");
		System.out.println("3. Update Order Status ");
		System.out.println("4. Go Back ");
		System.out.println("5. Exit ");
		System.out.println("Please Enter your Choice(1-5): ");
		int choice = input.nextInt();
		switch(choice)
		{
		case 1:
			
		case 2:
			
		case 3:
			
		case 4:
			
		case 5:
			Runtime.getRuntime().halt(0);
			
		default:
			 System.out.println("Enter either 1 or 2 or 3 or 4 or 5");
		}
		
		input.close();
	}

}
