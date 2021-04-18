package com.grababiteapp.accounts;

import java.util.Scanner;

import com.grababiteapp.exception.IdNotFoundException;
import com.grababiteapp.exception.InvalidCredentialsException;
import com.grababiteapp.model.Menu;
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

		} else {
			int custId = result;
			System.out.println("Login Successfull");
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
				System.out.println(custService.showFoodMenu());
				break;
			case 2:
				System.out.println(custService.showProfile(custId));
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
					} else {
						System.out.println("Action Not Completed");
					}
				} else if (choice4 == 3) {
					int result2 = 0;
					System.out.println("Enter the order ID  : ");
					int orderId = sc.nextInt();
					try {
						result2 = custService.placeOrder(orderId);
					} catch (IdNotFoundException e) {
						e.getMessage();
					}
					if (result2 == 1) {
						System.out.println("Order with Id " + orderId + " Delivered Successfully");
					} else {
						System.out.println("Action Not Completed");
					}
				} else if (choice4 == 4) {
					loginForCustomer();
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
				} else {
					System.out.println("Action Not Completed");
				}
				break;
			case 5:
				try {
					System.out.println(custService.showOrdersHistory(custId));
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
		} else {
			System.out.println("Login Successfull");
			int restId = result;
			System.out.println("Welcome ");
			System.out.println("1. Edit Menu ");
			System.out.println("2. Show Profile ");
			System.out.println("3. Update Order Status ");
			System.out.println("4. Exit ");
			System.out.println("Please Enter your Choice(1-5): ");
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
					} else {
						System.out.println("Action Not Completed");
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
					} else {
						System.out.println("Action Not Completed");
					}
				} else if (choice3 == 4) {
					loginForRestaurant();
				} else {
					System.out.println("Enter either 1 or 2 or 3 or 4 ");
				}
				break;
			case 2:
				System.out.println(restService.showProfile(restId));
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
					} else {
						System.out.println("Action Not Completed");
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
					} else {
						System.out.println("Action Not Completed");
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
					} else {
						System.out.println("Action Not Completed");
					}
				} else if (choice4 == 4) {
					loginForRestaurant();
				} else {
					System.out.println("Enter either 1 or 2 or 3 or 4");
				}
				break;
			case 4:
				Runtime.getRuntime().halt(0);

			default:
				System.out.println("Enter either 1 or 2 or 3 or 4");
			}
			sc.close();
		}
	}
}
