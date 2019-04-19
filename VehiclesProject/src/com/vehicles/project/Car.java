package com.vehicles.project;

import java.util.List;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception("Wheel list must have two items!"); // added exception description message

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception("Right and left wheels must be equal!"); // added exception description message

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}
	
	// Override toString method
	public String toString() {
		return "Car plate: " + this.getPlate() + 
				"\nCar brand: " + this.getBrand() + 
				"\nCar color: " + this.getColor() +
				"\nNumber of wheels: " + this.getWheels().size() +
				"\nFront wheels brand: " + this.getWheels().get(0).getBrand() +
				"\nFront wheels diameter: " + this.getWheels().get(0).getDiameter() +
				"\nBack wheels brand: " + this.getWheels().get(2).getBrand() +
				"\nBack wheels diameter: " + this.getWheels().get(2).getDiameter();
	}
	
}
