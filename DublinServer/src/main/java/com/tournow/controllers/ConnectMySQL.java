package com.tournow.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tournow.model.Car;


public class ConnectMySQL {
	
	
	private static String user = "root";
	private static String password = "";
	
	static Gson gson = new Gson();
	
	public static Connection connect() {
		
		String url = "jdbc:mysql://localhost:3306/dublin";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static List<Car> getAvailableCar() throws SQLException{
		Connection conn = connect();
		
		String sql = "select * from dublin where isRent = 0;";
		PreparedStatement pstmt;
		List<Car> cars = new ArrayList<>();
	
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int col = rs.getMetaData().getColumnCount();	
		while (rs.next()) {
			Car car = new Car();
			car.setRegistration_number(rs.getInt(1));
			car.setModel(rs.getString(2));
			car.setManufacturer(rs.getString(3));
			car.setPrice(rs.getInt(4));				
			car.setCity(rs.getString(5));
			cars.add(car);
		}
		conn.close();
		
		return cars;
	}
	
	public static void rentCar(Integer id) throws SQLException {
		Connection conn = connect();
		int i = 0;
		PreparedStatement pstmt;
		String sql = "update dublin set isRent = 1 where registration_number = " +  id;
		pstmt = (PreparedStatement)conn.prepareStatement(sql);
		i = pstmt.executeUpdate(sql);
	}
	
	
	
	public static void returnCar(Integer id) throws SQLException {
		Connection conn = connect();
		int i = 0;
		PreparedStatement pstmt;
		String sql = "update dublin set isRent = 0 where registration_number = " +  id;
		pstmt = (PreparedStatement)conn.prepareStatement(sql);
		i = pstmt.executeUpdate(sql);
	}
	

}
