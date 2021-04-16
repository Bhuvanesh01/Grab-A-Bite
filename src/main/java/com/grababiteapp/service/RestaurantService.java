package com.grababiteapp.service;

import com.grababiteapp.exception.InvalidCredentialsException;
import com.grababiteapp.exception.IdNotFoundException;
import com.grababiteapp.exception.UserAlreadyPresentException;
import com.grababiteapp.model.Menu;
import com.grababiteapp.model.Restaurant;

public interface RestaurantService {

	int loginForRestaurant(String email, String password) throws InvalidCredentialsException;

	public void restaurantSignup(Restaurant resturantDetails);

	int checkAlreadyRegistered(String restEmail) throws UserAlreadyPresentException;

	void addFoodItem(Menu fooddetails);

	int deleteFoodItem(int foodItemId) throws IdNotFoundException;

	int updateFoodItemDetails(int foodItemId, double price) throws IdNotFoundException;

	int acceptOrder(int orderId) throws IdNotFoundException;

	int rejectOrder(int orderId) throws IdNotFoundException;

	Restaurant showProfile(int restId);

	int changeOrderStatus(int orderId) throws IdNotFoundException;

}
