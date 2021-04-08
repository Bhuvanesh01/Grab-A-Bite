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
		String sql = "create table Customer(custname varchar(20), custid integer primary key,"
				+" custemail varchar(20),custpassword varchar(20), custphone integer,custaddress varchar(20))";
		String sql2 = "create table Restaurant(restname varchar(20), restid integer primary key,"
				+" restemail varchar(20),restpassword varchar(20), restphone integer,restaddress varchar(20))";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "system";
		connection = DriverManager.getConnection(url,username,password);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
		statement.close();
		PreparedStatement statement2 = connection.prepareStatement(sql2);
		statement2.execute();
		statement2.close();
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
