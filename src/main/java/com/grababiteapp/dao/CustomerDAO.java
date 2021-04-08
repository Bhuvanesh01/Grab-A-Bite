package com.grababiteapp.dao;

public interface CustomerDAO {

	void addFoodItem();
	void deleteFoodItem(int foodItemId);
	void placeOrder();
	void cancelOrder();
	void showProfile();
	void showFoodMenu();
	
}
