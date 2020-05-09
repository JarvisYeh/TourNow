package controllers;

import java.util.List;


import javax.inject.Inject;

import models.Car;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.cars.searchPage;
import views.html.cars.*;

public class CarController extends Controller{
	@Inject
	FormFactory formFactory;
	
	/*
	 * Method to save a car into database
	 */
	public Result save(){
		Form<Car> carForm = formFactory.form(Car.class).bindFromRequest();
		//Verify the input first
		if (carForm.hasErrors())
		{
			flash("danger","Please Correst the Form Below");
			return badRequest(create.render(carForm));
		}
		
		Car car = carForm.get();
		car.save();
		flash("success","Save the Car Successtully");
		
		return redirect(routes.CarController.showRentedCars());
	}
	
	/*
	 * Methods required for renting a cars
	 * showRentedCars()
	 * rentCar()
	 */
	public Result showRentedCars()
	{
		List<Car> cars = Car.find.all();
		return ok(showRentedCars.render(cars));
	}
	
	public Result returnCar(Integer id)
	{		
		Car car = Car.find.byId(id);
		if(car == null)
		{
			flash("danger","This car is not curretnly rented");
			return notFound();
		}
		car.delete();
		flash("success","Return the Car Successtully");
		List<Car> cars = Car.find.all();
		return ok(showRentedCars.render(cars));
	}
	
	
	/*
	 * Showing the search page
	 * get the user's ip and pass it to view
	 * front-end will deal with all the search work
	 */
	public Result searchPage()
	{
		Integer newId = Car.find.all().size()+1;
		String ip = request().remoteAddress();
		return ok(searchPage.render(ip, newId));
	}

	/*
	 * Rent the car
	 * Deal with POST request that will add the selected car to the data base
	 * Info pass through URL parameter
	 */
	public Result rentCar(Integer id, Integer reg, String model, String man, Integer price, String city)
	{	
		//If the car with the specific id exist in the database
		//manually increase id to a value that is not exist in database
		//that's because id is the primary key in our database, it's not allowed to be duplicate
		while(Car.find.byId(id)!=null)
		{
			id = id+1;
		}
		Car car = new Car(id, reg, model,man, price, city);
		car.save();
		List<Car> cars = Car.find.all();
		return ok(showRentedCars.render(cars));	
	}
	


}
