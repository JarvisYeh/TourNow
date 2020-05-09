package com.tournow.model;


public class Car {
	int registration_number;
	String model;
	String manufacturer;
	int price;
	String city;
	boolean isRent;

	public Car() {
	}

	public int getRegistration_number() {
		return registration_number;
	}

	public void setRegistration_number(int registration_number) {
		this.registration_number = registration_number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isRent() {
		return isRent;
	}

	public void setRent(boolean isRent) {
		this.isRent = isRent;
	}

	


}
