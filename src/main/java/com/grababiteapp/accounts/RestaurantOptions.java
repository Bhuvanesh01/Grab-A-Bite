package com.grababiteapp.accounts;

import java.util.Scanner;

import com.grababiteapp.exception.IdNotFoundException;
import com.grababiteapp.model.Menu;
import com.grababiteapp.service.RestaurantService;
import com.grababiteapp.service.RestaurantServiceImpl;

public class RestaurantOptions {
	static void restOptions(int result) {
		int restId = result;
		Scanner sc = new Scanner(System.in);
		RestaurantService restService = new RestaurantServiceImpl();
		System.out.println("Welcome ");
		System.out.println("1. Edit Menu ");
		System.out.println("2. Show Profile ");
		System.out.println("3. Update Order Status ");
		System.out.println("4. Exit ");
		System.out.println("Please Enter your Choice(1-4): ");
		int choice2 = sc.nextInt();
		switch (choice2) {
		case 1:
			System.out.println("Edit the Menu By Choosing the Desired options..");
			System.out.println("Enter 1 to Add Food Item");
			System.out.println("Enter 2 to Delete Food Item");
			System.out.println("Enter 3 to Update Price Of a Food Item");
			System.out.println("Enter 4 to Go Back");
			int choice3 = sc.nextInt();
			sc.nextLine();
			if (choice3 == 1) {
				System.out.println("Enter Name :");
				String name = sc.nextLine();
				System.out.println("Enter Cuisine Name :");
				String cuisine = sc.nextLine();
				System.out.println("Enter Type (Veg/Non-veg) :");
				String type = sc.nextLine();
				System.out.println("Enter Price :");
				double price = sc.nextDouble();
				sc.nextLine();
				Menu fooddetails = new Menu(name, cuisine, type, price, restId);
				restService.addFoodItem(fooddetails);
				restOptions(result);
			} else if (choice3 == 2) {
				int result2 = 0;
				System.out.println("Enter Id of the Food Item : ");
				int foodId = sc.nextInt();
				try {
					result2 = restService.rejectOrder(foodId);
				} catch (IdNotFoundException e) {
					e.getMessage();
				}
				if (result2 == 1) {
					System.out.println("Food Item with Id " + foodId + " Deleted Successfully");
					restOptions(result);
				} else {
					System.out.println("Action Not Completed");
					restOptions(result);
				}
			} else if (choice3 == 3) {
				int result2 = 0;
				System.out.println("Enter Id of the Food Item : ");
				int foodId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the new price of the Food Item : ");
				double price = sc.nextDouble();
				try {
					result2 = restService.updateFoodItemDetails(foodId, price);
				} catch (IdNotFoundException e) {
					e.getMessage();
				}
				if (result2 == 1) {
					System.out.println("Food Item with Id " + foodId + " Updated Successfully");
					restOptions(result);
				} else {
					System.out.println("Action Not Completed");
					restOptions(result);
				}
			} else if (choice3 == 4) {
				restOptions(result);
			} else {
				System.out.println("Enter either 1 or 2 or 3 or 4 ");
			}
			break;
		case 2:
			int ch = 0;
			while (ch != 1) {
				System.out.println(restService.showProfile(restId));
				System.out.println("Enter 1 to Go Back: ");
				ch = sc.nextInt();
			}
			restOptions(result);
			break;
		case 3:
			System.out.println("Change Order Status");
			System.out.println("Enter 1 to Accept Order");
			System.out.println("Enter 2 to Reject Order");
			System.out.println("Enter 3 to Deliver Order");
			System.out.println("Enter 4 to Go Back");
			int choice4 = sc.nextInt();
			if (choice4 == 1) {
				int result2 = 0;
				System.out.println("Enter the Order ID : ");
				int orderId = sc.nextInt();
				try {
					result2 = restService.acceptOrder(orderId);
				} catch (IdNotFoundException e) {
					e.getMessage();
				}
				if (result2 == 1) {
					System.out.println("Order with Id " + orderId + " Placed Successfully");
					restOptions(result);
				} else {
					System.out.println("Action Not Completed");
					restOptions(result);
				}
			} else if (choice4 == 2) {
				int result2 = 0;
				System.out.println("Enter Id of the Food Item : ");
				int orderId = sc.nextInt();
				try {
					result2 = restService.rejectOrder(orderId);
				} catch (IdNotFoundException e) {
					e.getMessage();
				}
				if (result2 == 1) {
					System.out.println("Order with Id " + orderId + " Deleted Successfully");
					restOptions(result);
				} else {
					System.out.println("Action Not Completed");
					restOptions(result);
				}
			} else if (choice4 == 3) {
				int result2 = 0;
				System.out.println("Enter the order ID  : ");
				int orderId = sc.nextInt();
				try {
					result2 = restService.changeOrderStatus(orderId);
				} catch (IdNotFoundException e) {
					e.getMessage();
				}
				if (result2 == 1) {
					System.out.println("Order with Id " + orderId + " Delivered Successfully");
					restOptions(result);
				} else {
					System.out.println("Action Not Completed");
					restOptions(result);
				}
			} else if (choice4 == 4) {
				restOptions(result);
			} else {
				System.out.println("Enter either 1 or 2 or 3 or 4");
			}
			break;
		case 4:
			System.out.println("GoodBye!!!");
			Runtime.getRuntime().halt(0);

		default:
			System.out.println("Enter either 1 or 2 or 3 or 4");
		}
		sc.close();
	}
}
