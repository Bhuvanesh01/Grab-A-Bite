package com.grababiteapp.service;

import java.util.stream.Collectors;

import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.grababiteapp.dao.RestaurantDAO;
import com.grababiteapp.dao.RestaurantDAOImpl;
import com.grababiteapp.model.Restaurant;

public class RestaurantServiceImpl implements RestaurantService {

	public static void main(String[] args) {

	}

	RestaurantDAO restaurantDAO=new RestaurantDAOImpl();

	public void addFoodItem() {
		
			restaurantDAO.addFoodItem();
		
	}

	public void deleteFoodItem(int foodItemId) {
		restaurantDAO.deleteFoodItem(foodItemId);
			
	}

	public void updateFoodItemDetails(int foodItemId, double price) {
		restaurantDAO.updateFoodItemDetails( foodItemId,price);
	}

	public void acceptOrder(int orderId) {
		restaurantDAO.acceptOrder( orderId);
		
	}

	public void rejectOrder(int orderId) {
		restaurantDAO.rejectOrder( orderId);
	}

	public void showProfile() {
		restaurantDAO.showProfile();
		
	}

	public void changeOrderStatus(int orderId) {
		
		restaurantDAO.changeOrderStatus( orderId);
	}

}
