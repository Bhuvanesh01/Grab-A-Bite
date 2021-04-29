package com.grababiteapp.accounts;

import java.util.Scanner;

import com.grababiteapp.exception.FoodItemNotFoundException;
import com.grababiteapp.exception.IdNotFoundException;
import com.grababiteapp.service.CustomerService;
import com.grababiteapp.service.CustomerServiceImpl;

public class CustomerOptions {
	static void custOptions(int result) {
		int custId = result;
		Scanner sc = new Scanner(System.in);
		CustomerService custService = new CustomerServiceImpl();
		System.out.println("Welcome ");
		System.out.println("1. Show Menu ");
		System.out.println("2. Show Profile ");
		System.out.println("3. Place Order ");
		System.out.println("4. Cancel Order ");
		System.out.println("5. Show Orders ");
		System.out.println("6. Exit ");
		System.out.println("Please Enter your Choice(1-7): ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("See Menu Here: ");
			System.out.println("Enter 1 to Show Full Menu");
			System.out.println("Enter 2 to See Menu By Cuisine");
			System.out.println("Enter 3 to See Menu By Restaurant");
			System.out.println("Enter 4 to Go Back");
			int choice0 = sc.nextInt();
			sc.nextLine();
			if (choice0 == 1) {
				System.out.println(custService.showFoodMenu());
				custOptions(custId);
			} else if (choice0 == 2) {
				System.out.println("Enter Cuisine Name : ");
				String cuisine = sc.nextLine();
				try {
					System.out.println(custService.findFoodByCuisine(cuisine));
					custOptions(custId);
				} catch (FoodItemNotFoundException e) {
					e.printStackTrace();
				}

			} else if (choice0 == 3) {
				System.out.println("Enter the Restaurant ID  : ");
				int restId = sc.nextInt();
				try {
					System.out.println(custService.findFoodByRestaurant(restId));
					custOptions(custId);
				} catch (FoodItemNotFoundException e) {
					e.printStackTrace();
				}

			} else if (choice0 == 4) {
				custOptions(custId);
			} else {
				System.out.println("Enter either 1 or 2 or 3 or 4");
			}
			break;
		case 2:
			int ch = 0;
			while (ch != 1) {
				System.out.println(custService.showProfile(custId));
				System.out.println("Enter 1 to Go Back: ");
				ch = sc.nextInt();
			}
			custOptions(custId);
			break;
		case 3:
			System.out.println("Place your Orders Here:");
			System.out.println("Enter 1 to Add Food Item");
			System.out.println("Enter 2 to Delete Food Item");
			System.out.println("Enter 3 to Place Order");
			System.out.println("Enter 4 to Go Back");
			int choice4 = sc.nextInt();
			if (choice4 == 1) {
				System.out.println("Enter the Food ID : ");
				int foodId = sc.nextInt();
				System.out.println("Enter Quantity : ");
				int quantity = sc.nextInt();
				custService.addFoodItem(custId, foodId, quantity);
				custOptions(custId);

			} else if (choice4 == 2) {
				int result2 = 0;
				System.out.println("Enter Id of the Food Item : ");
				int foodId = sc.nextInt();
				try {
					result2 = custService.deleteFoodItem(foodId);
				} catch (IdNotFoundException e) {
					e.getMessage();
				}
				if (result2 == 1) {
					System.out.println("Order with Id " + foodId + " Deleted Successfully");
					custOptions(custId);
				} else {
					System.out.println("Action Not Completed");
					custOptions(custId);
				}
			} else if (choice4 == 3) {
				int result2 = 0;
				System.out.println("Enter the order ID  : ");
				int orderId = sc.nextInt();
				try {
					result2 = custService.placeOrder(orderId);
					double total = custService.total(orderId);
					System.out.println("Total Amount For This Order is: " + total);
				} catch (IdNotFoundException e) {
					e.getMessage();
				}
				if (result2 == 1) {
					System.out.println("Order with Id " + orderId + " Placed Successfully");
					custOptions(custId);
				} else {
					System.out.println("Action Not Completed");
					custOptions(custId);
				}
			} else if (choice4 == 4) {
				custOptions(custId);
			} else {
				System.out.println("Enter either 1 or 2 or 3 or 4");
			}
			break;
		case 4:
			System.out.println("Enter Order Id of the Order You want to Cancel : ");
			int orderId = sc.nextInt();
			int result2 = 0;
			try {
				result2 = custService.cancelOrder(orderId);
			} catch (IdNotFoundException e) {
				System.out.println(e.getMessage());
			}
			if (result2 == 1) {
				System.out.println("Order with Id " + orderId + " Cancelled Successfully");
				custOptions(custId);
			} else {
				System.out.println("Action Not Completed");
				custOptions(custId);
			}
			break;
		case 5:
			try {
				System.out.println(custService.showOrdersHistory(custId));
				custOptions(custId);
			} catch (IdNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 6:
			Runtime.getRuntime().halt(0);
		default:
			System.out.println("Enter either 1 or 2 or 3 or 4 or 5 or 6");
		}
		sc.close();
	}
}