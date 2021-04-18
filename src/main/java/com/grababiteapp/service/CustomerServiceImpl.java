package com.grababiteapp.service;

import java.util.List;

import com.grababiteapp.dao.CustomerDAO;
import com.grababiteapp.dao.CustomerDAOImpl;
import com.grababiteapp.exception.IdNotFoundException;
import com.grababiteapp.exception.InvalidCredentialsException;
import com.grababiteapp.exception.UserAlreadyPresentException;
import com.grababiteapp.model.Customer;
import com.grababiteapp.model.Menu;
import com.grababiteapp.model.Orders;

public class CustomerServiceImpl implements CustomerService {

	CustomerDAO customerDAO = new CustomerDAOImpl();

	public int loginForCustomer(String email, String password) throws InvalidCredentialsException {
		int result = customerDAO.loginForCustomer(email, password);
		if (result == 0)
			throw new InvalidCredentialsException("Inavlid Username or Password! Please try Again.");
		else {
			return result;
		}
	}

	public void customerSignup(Customer customerDetails) {
		customerDAO.customerSignup(customerDetails);
	}

	public int checkAlreadyRegistered(String custEmail) throws UserAlreadyPresentException {
		int result = customerDAO.checkAlreadyRegistered(custEmail);
		if (result == 1)
			throw new UserAlreadyPresentException(
					"This User is already Registered! Please use a Different Email to Register.");
		else {
			return result;
		}
	}

	public void addFoodItem(int custid, int foodid, int quantity) {
		customerDAO.addFoodItem(custid, foodid, quantity);
	}

	public int deleteFoodItem(int foodItemId) throws IdNotFoundException {
		int result = customerDAO.deleteFoodItem(foodItemId);
		if (result == 0)
			throw new IdNotFoundException("No Food Item with " + foodItemId + "Found");
		else {
			return result;
		}
	}

	public int placeOrder(int orderid) throws IdNotFoundException {
		int result = customerDAO.placeOrder(orderid);
		if (result == 0)
			throw new IdNotFoundException("No Orders with " + orderid + "Found");
		else {
			return result;
		}
	}

	public int cancelOrder(int orderid) throws IdNotFoundException {
		int result = customerDAO.cancelOrder(orderid);
		if (result == 0)
			throw new IdNotFoundException("No Orders with " + orderid + "Found");
		else {
			return result;
		}
	}

	public Customer showProfile(int custId) {
		return customerDAO.showProfile(custId);
	}

	public List<Menu> showFoodMenu() {
		return customerDAO.showFoodMenu();
	}

	public List<Orders> showOrdersHistory(int custid) throws IdNotFoundException {
		return customerDAO.showOrdersHistory(custid);
	}

}
