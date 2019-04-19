package com.vehicles.project;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	
	public void addWheels(Wheel frontWheel, Wheel backWheel) {
		this.wheels.add(frontWheel);
		this.wheels.add(backWheel);
	}
	
	// Override toString method
	public String toString() {
		return "Bike plate: " + this.getPlate() 
			+ "\nBike brand: " + this.getBrand() 
			+ "\nBike color: " + this.getColor()
			+ "\nNumber of wheels: " + this.getWheels().size()
			+ "\nFront wheel brand: " + this.getWheels().get(0).getBrand()
			+ "\nFront wheel diameter: " + this.getWheels().get(0).getDiameter()
			+ "\nBack wheel brand: " + this.getWheels().get(1).getBrand()
			+ "\nBack wheel diameter: " + this.getWheels().get(1).getDiameter();
	}

}
