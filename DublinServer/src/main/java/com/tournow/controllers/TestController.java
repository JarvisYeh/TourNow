package com.tournow.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tournow.model.Car;

@RestController
public class TestController {

	
	@RequestMapping(value = "/getCars", method = RequestMethod.GET)
	public List<Car> getCars() throws SQLException {	
		ConnectMySQL.connect();
		List<Car> cars = ConnectMySQL.getAvailableCar();
		return cars;	
	}
	
	@RequestMapping(value = "/rent", method = RequestMethod.GET)
	public String rentCar(@RequestParam("id") Integer id) throws SQLException {
		ConnectMySQL.connect();
		ConnectMySQL.rentCar(id);
		return "Status of the car has been updated successfully";
	}
	
	
	@RequestMapping(value = "/return", method = RequestMethod.GET)
	public String returnCar(@RequestParam("id") Integer id) throws SQLException {
		ConnectMySQL.connect();
		ConnectMySQL.returnCar(id);
		return "Status of the car has been updated successfully";
		
	}


}
