package com.grababiteapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.grababiteapp.model.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO {

		public void addFoodItem() {
		String sql = "insert into menu values(?,?,?,?,?,?)";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, order.getorderrestId());
			statement.setString(2, order.getorderfoodName());
			statement.setInt(3, order.getorderfoodId());
			statement.setDouble(4, order.getorderprice());
			statement.setString(5, order.getorderrestquantity());
		
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

	public void deleteFoodItem(int foodItemId) {
		String sql = "update from menu where orderfoodid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1,orderfoodid);
			
			result = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
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
	

	public void updateFoodItemDetails(int foodItemId, double price) {
		String sql = "update menu set orderprice=? where foodid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, foodId);
			
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
	

	public void acceptOrder(int orderId) {
		String sql = "update order set price=? where foodid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, foodId);
			statement.setDouble(2,price );
			
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

	public void rejectOrder(int orderId) {
		String sql = "update from order where orderfoodid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1,foodid);
			
			result = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
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

	public void showProfile() {
		
		String sql = "select * from restaurent";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<Order> orderList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
			  String foodname = rs.getString("food name");
			 int foodId = rs.getInt(" foodId");
			  double  foodprice= rs.getDouble("food price");
			  String  quantity= rs.getString("food quantity");
			  int  orderrestId= rs.getInt("restaurant id");		
			 Order order= new Order(foodname, foodid, foodprice, foodquantity, restId);
			 orderList.add(order);
			}			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if(statement!=null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();		
	}
		return ;
	}

	public void changeOrderStatus(int orderId) {
		String sql = "update menu set price=? where foodid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, foodId);
			statement.setString(1, foodname);
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

	}}
