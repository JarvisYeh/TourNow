package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Constraint;
import play.data.validation.*;

import com.avaje.ebean.Model;

@Entity
public class Car extends Model{
	
	@Id
	@Constraints.Required
	public Integer id;
	@Constraints.Required	
	public Integer registration_number;
	@Constraints.Required
	public String model;
	@Constraints.Required
	public String manufacturer;
	@Constraints.Required
	public Integer price;
	@Constraints.Required
	public String city;

	
	public Car(Integer id, Integer registration_number, String model, String manufacturer, Integer price, String city) {
		this.id = id;
		this.registration_number = registration_number;
		this.model = model;
		this.manufacturer = manufacturer;
		this.price = price;
		this.city = city;
	}

	public static Finder<Integer,Car>  find = new Finder<>(Car.class);
	
	
}