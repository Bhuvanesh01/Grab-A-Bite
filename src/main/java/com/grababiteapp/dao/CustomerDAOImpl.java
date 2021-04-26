package com.grababiteapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grababiteapp.model.Customer;
import com.grababiteapp.model.Menu;
import com.grababiteapp.model.Orders;

public class CustomerDAOImpl implements CustomerDAO {

	public int loginForCustomer(String email, String password) {
		String sql = "select custid, custemail, custpassword from Customer where custemail = ? and custpassword = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int custid = 0;
		try {
			statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String custEmail = rs.getString("custemail");
				String custPassword = rs.getString("custpassword");
				if (custEmail.equals(email) && (custPassword.equals(password)))
					custid = rs.getInt(1);
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
		return custid;

	}

	public int checkAlreadyRegistered(String custEmail) {
		String sql = "Select custemail from customer where custemail=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, custEmail);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String email = rs.getString("custemail");
				if (custEmail.equals(email)) {
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

	public void customerSignup(Customer customerDetails) {
		String sql = "insert into Customer(custname,custemail,custpassword,custphone,custaddress) values(?,?,?,?,?)";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, customerDetails.getCustName());
			statement.setString(2, customerDetails.getCustEmail());
			statement.setString(3, customerDetails.getCustPassword());
			statement.setInt(4, customerDetails.getCustPhone());
			statement.setString(5, customerDetails.getCustAddress());
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

	public void addFoodItem(int custid, int foodid, int quantity) {
		String sql = "insert into Orders(foodname,price,restid) select m.foodname,m.price,m.restid from Menu m where m.foodid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, foodid);
			statement.executeUpdate();
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
		String sql2 = "update Orders set custid = ?, quantity = ? ";
		Connection connection2 = DBConnection.openConnection();
		PreparedStatement statement2 = null;
		try {
			statement2 = connection2.prepareStatement(sql2);
			statement2.setInt(1, custid);
			statement2.setInt(2, quantity);
			statement2.executeUpdate();
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
		String sql = "delete from Orders where foodid=?";
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

	public int placeOrder(int orderid) {
		String sql = "update Orders set status = ? where orderid = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		String status = "Order_Placed";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, status);
			statement.setInt(2, orderid);
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

	public int cancelOrder(int orderid) {
		String sql = "delete from Orders where orderid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, orderid);
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

	public Customer showProfile(int custId) {
		String sql = "select * from Customer where custid = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		Customer custDetails = null;
		try {
			statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setInt(1, custId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int custid = rs.getInt(1);
				String custName = rs.getString("custname");
				String email = rs.getString("custemail");
				String password = rs.getString("custpassword");
				int phone = rs.getInt("custphone");
				String address = rs.getString("custaddress");
				custDetails = new Customer(custid, custName, email, password, phone, address);
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
		return custDetails;
	}

	public List<Menu> showFoodMenu() {
		String sql = "select * from Menu";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<Menu> menu = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int foodid = rs.getInt(1);
				String name = rs.getString("foodname");
				String cuisine = rs.getString("cuisine");
				String foodtype = rs.getString("foodtype");
				double price = rs.getDouble("price");
				int restid = rs.getInt(6);
				Menu foodDetails = new Menu(foodid, name, cuisine, foodtype, price, restid);
				menu.add(foodDetails);
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
		return menu;
	}

	public List<Orders> showOrdersHistory(int custid) {
		String sql = "select orderid,foodname,price,quantity,status from orders where custid = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<Orders> orderList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setInt(1, custid);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int orderid = rs.getInt("orderid");
				String foodname = rs.getString("foodname");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				String status = rs.getString("status");
				Orders order = new Orders(orderid, foodname, price, quantity, status);
				orderList.add(order);
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
		return orderList;
	}

	@Override
	public double total(int orderid) {
		String sql = "select price,quantity from Orders where orderid = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		double total = 0;
		try {
			statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setInt(1, orderid);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				double price = rs.getInt(1);
				int quantity = rs.getInt(2);
				total = price * quantity;
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
		return total;
	}

	public List<Menu> findFoodByRestaurant(int restId) {
		String sql = "select * from Menu where restid=?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<Menu> foodList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setInt(1, restId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int foodid = rs.getInt(1);
				String name = rs.getString("foodname");
				String cuisine = rs.getString("cuisine");
				String foodtype = rs.getString("foodtype");
				double price = rs.getDouble("price");
				int restid = rs.getInt(6);
				Menu foodDetails = new Menu(foodid, name, cuisine, foodtype, price, restid);
				foodList.add(foodDetails);
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
		return foodList;
	}

	public List<Menu> findFoodByCuisine(String cuisine) {
		String sql = "select * from Menu where cuisine like ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<Menu> foodList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, "%" + cuisine + "%");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int foodid = rs.getInt(1);
				String name = rs.getString("foodname");
				String cuisine1 = rs.getString("cuisine");
				String foodtype = rs.getString("foodtype");
				double price = rs.getDouble("price");
				int restid = rs.getInt(6);
				Menu foodDetails = new Menu(foodid, name, cuisine1, foodtype, price, restid);
				foodList.add(foodDetails);
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
		return foodList;
	}
}
