package com.grababiteapp.dao;

import com.grababiteapp.model.Menu;
import com.grababiteapp.model.Restaurant;

public interface RestaurantDAO {

	int loginForRestaurant(String email, String password);

	public void restaurantSignup(Restaurant resturantDetails);

	int checkAlreadyRegistered(String restEmail);

	void addFoodItem(Menu fooddetails);

	int deleteFoodItem(int foodItemId);

	int updateFoodItemDetails(int foodItemId, double price);

	int acceptOrder(int orderId);

	int rejectOrder(int orderId);

	Restaurant showProfile(int restId);

	int changeOrderStatus(int orderId);

}
