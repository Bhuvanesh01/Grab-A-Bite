package com.grababiteapp.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner option = new Scanner(System.in, "UTF-8");
		System.out.println("Grab-A-Bite");
	    System.out.println("-----------------------");
	    System.out.println("Select: ");
	    System.out.println("1. For Customer Login");
	    System.out.println("2. For Restaurant Login");
	    System.out.println("3. For New Customer Signup");
	    System.out.println("4. For New Restaurant Signup");
	    System.out.println("5. Exit");
	    System.out.println("Enter your choice:");
	      try{ 
	      int menuOption = option.nextInt();
	      switch (menuOption) {
	        case 1:
//	          loginForCustomer();
	          break;
	        case 2:
//	          loginForRestaurant();
	          break;
	        case 3:
//	          customerSignup();
	          break;
	        case 4:
//	          restaurantSignup();
	          break;
	        case 5:
	          Runtime.getRuntime().halt(0);
	        default:
	          System.out.println("Enter either 1 or 2 or 3 or 4 or 5");
	      }
	    } catch (Exception e) {
	      e.getMessage();
	      System.out.println("Enter a valid value");
	    }
	      option.close();
	}

}
