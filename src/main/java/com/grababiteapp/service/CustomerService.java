package com.grababiteapp.service;

public interface CustomerService {

	void addFoodItem();
	void deleteFoodItem(int foodItemId);
	void placeOrder();
	void cancelOrder();
	void showProfile();
	void showFoodMenu();
}
