package com.grababiteapp.dao;

import java.util.List;

import com.grababiteapp.model.Customer;
import com.grababiteapp.model.Menu;

public interface CustomerDAO {

	int loginForCustomer(String email, String password);

	void customerSignup(Customer customerDetails);

	int checkAlreadyRegistered(String restEmail);

	void addFoodItem(Menu menu);

	int deleteFoodItem(int foodItemId);

	int placeOrder(int orderid);

	int cancelOrder(int orderid);

	Customer showProfile(int custId);

	List<Menu> showFoodMenu();
//	void showOrdersHistory();

}
