package com.grababiteapp.service;

import com.grababiteapp.dao.CustomerDAO;
import com.grababiteapp.dao.CustomerDAOImpl;

public class CustomerServiceImpl implements CustomerService {

	CustomerDAO customerDAO = new CustomerDAOImpl(); 

	public void addFoodItem() {
		customerDAO.addFoodItem();
	}

	public void deleteFoodItem(int foodItemId) {
		customerDAO.deleteFoodItem(foodItemId);
	}

	public void placeOrder() {
		customerDAO.placeOrder();
	}

	public void cancelOrder() {
		customerDAO.cancelOrder();
	}

	public void showProfile() {
		customerDAO.showProfile();
	}

	public void showFoodMenu() {
		customerDAO.showFoodMenu();
	}

}
