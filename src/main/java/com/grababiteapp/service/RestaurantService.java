package com.grababiteapp.service;

public interface RestaurantService {
	
	void addFoodItem();
	void deleteFoodItem(int foodItemId);
	void updateFoodItemDetails(int foodItemId,double price);
	void acceptOrder(int orderId);
	void rejectOrder(int orderId);
	void showProfile();
	void changeOrderStatus(int orderId);
	
}
