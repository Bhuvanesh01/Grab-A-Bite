package com.grababiteapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grababiteapp.model.Customer;
import com.grababiteapp.model.Menu;
import com.grababiteapp.model.Order;

public class CustomerDAOImpl implements CustomerDAO {

	public void addFoodItem() {
		String sql = "insert into food values(?,?,?,?)";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		try {
		statement = connection.prepareStatement(sql);
		statement.setString(1, Menu.getName());
		statement.setInt(2, Menu.getfoodId());
		statement.setString(3, Menu.getcuisine());
		statement.setDouble(4, Menu.getfoodprice());
		statement.execute();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if(statement!=null)
				try {
					statement.close();
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
	}

	public void deleteFoodItem(int foodItemId) {
		String sql = "delete from food where foodid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, foodid);
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
	}

	public void placeOrder() {
		String sql = "insert into order values(?,?,?)";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		try {
		statement = connection.prepareStatement(sql);
		statement.setString(1, order.getordername());
		statement.setInt(2, order.getorderid());
		statement.setDouble(3, order.getorderprice());
		statement.execute();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if(statement!=null)
				try {
					statement.close();
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
	}

	public void cancelOrder() {
		String sql = "delete from order where orderid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		try {
		statement = connection.prepareStatement(sql);
		statement.setInt(1, order.getorderid());
		statement.execute();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if(statement!=null)
				try {
					statement.close();
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
	}

	public void showProfile() {
		String sql = "select * from customer";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<Customer> customer = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int custId = rs.getInt(1);
				String custName = rs.getString("name");
				String custEmail = rs.getString("email");
				String custPassword = rs.getString("password");
				int custPhone = rs.getInt(5);
				String custAddress = rs.getString("address");
				Customer cust = new Customer(custId, custName, custEmail, custPassword, custPhone, custAddress);
				customerList.add(cust);
			}
			} catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if(statement!=null)
				try {
					statement.close();
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();

		}
	}

	public void showFoodMenu() {
		String sql = "select * from food";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<Menu> menu = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String category = rs.getString("category");
				int foodid = rs.getInt(2);
				double price = rs.getDouble("price");
				Menu food = new Menu(name, foodid, category, price);
				menuList.add(food);
			}
			} catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if(statement!=null)
				try {
					statement.close();
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();

		}
	}

	public void showOrdersHistory() {
		String sql = "select * from order";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<Order> orderList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int orderid = rs.getInt(2);
				double orderprice = rs.getDouble("price");
				Order order = new Order(name, orderid, price);
				orderList.add(order);
			}
			} catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if(statement!=null)
				try {
					statement.close();
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();

		}
	}

}
