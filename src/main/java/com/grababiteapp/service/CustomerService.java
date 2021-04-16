package com.grababiteapp.service;

import java.util.List;

import com.grababiteapp.exception.IdNotFoundException;
import com.grababiteapp.exception.InvalidCredentialsException;
import com.grababiteapp.exception.UserAlreadyPresentException;
import com.grababiteapp.model.Customer;
import com.grababiteapp.model.Menu;

public interface CustomerService {

	int loginForCustomer(String email, String password) throws InvalidCredentialsException;

	void customerSignup(Customer customerDetails);

	int checkAlreadyRegistered(String restEmail) throws UserAlreadyPresentException;

	void addFoodItem();

	int deleteFoodItem(int foodItemId) throws IdNotFoundException;

	int placeOrder(int orderid) throws IdNotFoundException;

	int cancelOrder(int orderid) throws IdNotFoundException;

	Customer showProfile(int custId);

	List<Menu> showFoodMenu();
}
