package com.grababiteapp.service;

import java.util.List;

import com.grababiteapp.exception.IdNotFoundException;
import com.grababiteapp.exception.InvalidCredentialsException;
import com.grababiteapp.exception.UserAlreadyPresentException;
import com.grababiteapp.model.Customer;
import com.grababiteapp.model.Menu;
import com.grababiteapp.model.Orders;

public interface CustomerService {

	int loginForCustomer(String email, String password) throws InvalidCredentialsException;

	void customerSignup(Customer customerDetails);

	int checkAlreadyRegistered(String restEmail) throws UserAlreadyPresentException;

	void addFoodItem(int custid, int foodid, int quantity);

	int deleteFoodItem(int foodItemId) throws IdNotFoundException;

	int placeOrder(int orderid) throws IdNotFoundException;

	int cancelOrder(int orderid) throws IdNotFoundException;

	Customer showProfile(int custId);

	List<Menu> showFoodMenu();

	List<Orders> showOrdersHistory(int custid) throws IdNotFoundException;

	double total(int orderid);
}
