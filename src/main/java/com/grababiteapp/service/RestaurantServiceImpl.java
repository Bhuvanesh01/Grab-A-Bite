package com.grababiteapp.service;

import com.grababiteapp.dao.RestaurantDAO;
import com.grababiteapp.dao.RestaurantDAOImpl;
import com.grababiteapp.exception.InvalidCredentialsException;
import com.grababiteapp.exception.UserAlreadyPresentException;
import com.grababiteapp.exception.IdNotFoundException;
import com.grababiteapp.model.Menu;
import com.grababiteapp.model.Restaurant;

public class RestaurantServiceImpl implements RestaurantService {

	RestaurantDAO restaurantDAO = new RestaurantDAOImpl();

	public int loginForRestaurant(String email, String password) throws InvalidCredentialsException {
		int result = restaurantDAO.loginForRestaurant(email, password);
		if (result == 0)
			throw new InvalidCredentialsException("Invalid Useremail or Password! Please try Again.");
		else {
			return result;
		}
	}

	public void restaurantSignup(Restaurant resturantDetails) {
		restaurantDAO.restaurantSignup(resturantDetails);
	}

	public int checkAlreadyRegistered(String restEmail) throws UserAlreadyPresentException {
		int result = restaurantDAO.checkAlreadyRegistered(restEmail);
		if (result == 1)
			throw new UserAlreadyPresentException(
					"This User is already Registered! Please use a Different Email to Register.");
		else {
			return result;
		}
	}

	public void addFoodItem(Menu fooddetails) {

		restaurantDAO.addFoodItem(fooddetails);

	}

	public int deleteFoodItem(int foodItemId) throws IdNotFoundException {
		int result = restaurantDAO.deleteFoodItem(foodItemId);
		if (result == 0)
			throw new IdNotFoundException("No Food Item with " + foodItemId + "Found");
		else {
			return result;
		}
	}

	public int updateFoodItemDetails(int foodItemId, double price) throws IdNotFoundException {
		int result = restaurantDAO.updateFoodItemDetails(foodItemId, price);
		if (result == 0)
			throw new IdNotFoundException("No Food Item with " + foodItemId + "Found");
		else {
			return result;
		}
	}

	public int acceptOrder(int orderId) throws IdNotFoundException {
		int result = restaurantDAO.acceptOrder(orderId);
		if (result == 0)
			throw new IdNotFoundException("No Orders for" + orderId + "Found");
		else {
			return result;
		}

	}

	public int rejectOrder(int orderId) throws IdNotFoundException {
		int result = restaurantDAO.rejectOrder(orderId);
		if (result == 0)
			throw new IdNotFoundException("No Orders for" + orderId + "Found");
		else {
			return result;
		}
	}

	public Restaurant showProfile(int restId) {
		return restaurantDAO.showProfile(restId);

	}

	public int changeOrderStatus(int orderId) throws IdNotFoundException {

		int result = restaurantDAO.changeOrderStatus(orderId);
		if (result == 0)
			throw new IdNotFoundException("No Orders for" + orderId + "Found");
		else {
			return result;
		}
	}

}
