package com.grababiteapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.grababiteapp.model.Menu;
import com.grababiteapp.model.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO {

	public int loginForRestaurant(String email, String password) {
		String sql = "select restid, restemail , restpassword from Restaurant where restemail = ? and restpassword = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int restid = 0;
		try {
			statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String restEmail = rs.getString("restemail");
				String restPassword = rs.getString("restpassword");
				if (restEmail.equals(email) && (restPassword.equals(password)))
					restid = rs.getInt(1);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
		return restid;

	}

	public int checkAlreadyRegistered(String restEmail) {
		String sql = "Select restemail from restaurant where restemail=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, restEmail);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String email = rs.getString("restemail");
				if (restEmail.equals(email)) {
					result = 1;
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
		return result;
	}

	public void restaurantSignup(Restaurant resturantDetails) {

		String sql = "insert into Restaurant(restname,restemail,restpassword,restphone,restaddress) values(?,?,?,?,?)";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, resturantDetails.getRestName());
			statement.setString(2, resturantDetails.getRestEmail());
			statement.setString(3, resturantDetails.getRestPassword());
			statement.setInt(4, resturantDetails.getRestPhone());
			statement.setString(5, resturantDetails.getRestAddress());
			statement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
	}

	public void addFoodItem(Menu fooddetails) {

		String sql = "insert into Menu(foodname,cuisine,foodtype,price,restid) values(?,?,?,?,?)";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, fooddetails.getName());
			statement.setString(2, fooddetails.getCuisine());
			statement.setString(3, fooddetails.getType());
			statement.setDouble(4, fooddetails.getPrice());
			statement.setInt(5, fooddetails.getrestId());
			statement.execute();
			System.out.println("Details Added Successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}

	}

	public int deleteFoodItem(int foodItemId) {
		String sql = "delete from Menu where foodid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, foodItemId);
			result = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
		return result;
	}

	public int updateFoodItemDetails(int foodItemId, double price) {
		String sql = "update Menu set price=? where foodid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setDouble(1, price);
			statement.setInt(2, foodItemId);
			result = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
		return result;
	}

	public int acceptOrder(int orderId) {
		String sql = "update Orders set status=? where orderid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		String status = "Order_Confirmed";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, status);
			statement.setInt(2, orderId);
			result = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
		return result;

	}

	public int rejectOrder(int orderId) {
		String sql = "update Orders set status=? where orderid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		String status = "Order_Cancelled";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, status);
			statement.setInt(2, orderId);
			result = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
		return result;
	}

	public Restaurant showProfile(int restId) {

		String sql = "select * from Restaurant where restid = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		Restaurant restDetails = null;
		try {
			statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setInt(1, restId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int restid = rs.getInt(1);
				String restName = rs.getString("restname");
				String email = rs.getString("restemail");
				String password = rs.getString("restpassword");
				int phone = rs.getInt("restphone");
				String address = rs.getString("restaddress");
				restDetails = new Restaurant(restid, restName, email, password, phone, address);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
		return restDetails;
	}

	public int changeOrderStatus(int orderId) {
		String sql = "update Orders set status=? where orderid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		String status = "Delivered";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, status);
			statement.setInt(2, orderId);
			result = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
		return result;
	}

}
