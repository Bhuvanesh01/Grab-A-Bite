package com.grababiteapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
	
	static Connection connection;
	public static Connection openConnection()
	{
		try{
		String sql = "create table Customer(custid integer primary key, custname varchar(20), "
				+" custemail varchar(20),custpassword varchar(20), custphone integer,custaddress varchar(20))";
		String sql2 = "create table Restaurant( restid integer primary key, restname varchar(20),"
				+" restemail varchar(20),restpassword varchar(20), restphone integer,restaddress varchar(20))";
		String sql3 = "create table Menu(foodid integer primary key, foodname varchar(20),"
				+" cuisine varchar(20),foodtype varchar(20), price decimal,restid integer ,constraint fk_restid foreign key(restid) references Restaurant(restid) on delete cascade)";
		String sql4 = "create table Orders(orderid integer primary key,custid integer, foodname varchar(20),"
				+"price decimal, quantity integer,restid integer,status varchar(20) default 'Not_Ordered', foreign key(restid) references Restaurant(restid),"
	            + "foreign key(custid) references Customer(custid))";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "system";
		connection = DriverManager.getConnection(url,username,password);
//		PreparedStatement statement = connection.prepareStatement(sql);
//		statement.execute();
//		statement.close();
//		PreparedStatement statement2 = connection.prepareStatement(sql2);
//		statement2.execute();
//		statement2.close();
//		PreparedStatement statement3 = connection.prepareStatement(sql3);
//		statement3.execute();
//		statement3.close();
//		PreparedStatement statement4 = connection.prepareStatement(sql4);
//		statement4.execute();
//		statement4.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void closeConnection(){
		if(connection!=null)
		{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Connection to Database Closed");
		}
	}
}
