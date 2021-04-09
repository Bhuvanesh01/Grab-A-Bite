package com.grababiteapp.main;

import java.util.Scanner;

public class Main {
	  private Scanner option = new Scanner(System.in, "UTF-8");
	    private void loginOption() {
	      System.out.println("Canteen Management System");
	      System.out.println("-----------------------");
	      System.out.println("Select");
	      System.out.println("1. For Customer Login");
	      System.out.println("2. For Vendor Login");
	      System.out.println("3. For New Customer Signup");
	      System.out.println("4. For New Vendor Signup");
	      System.out.println("5. Exit");
	      loginSelect();
	    }
	    private void loginSelect() {
	      try {
	        System.out.println("Enter your choice:");
	        int menuOption = option.nextInt();
	        switch (menuOption) {
	          case 1:
//	            loginForCust();
	            break;
	          case 2:
//	            loginForVendor();
	            break;
	          case 3:
//	            customerSignup();
	            break;
	          case 4:
//	            vendorSignup();
	            break;
	          case 5:
	            Runtime.getRuntime().halt(0);
	          default:
	            System.out.println("Enter either 1 or 2 or 3 or 4 or 5");
	        }
	      } catch (Exception e) {
	        e.getMessage();
	        System.out.println("enter a valid value");
	      }
	      option.nextLine();
	      loginOption();
	    }
}
