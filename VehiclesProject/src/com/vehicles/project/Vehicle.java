package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}

	// Added getters and setters
	public final String getPlate() {
		return plate;
	}

	public final void setPlate(String plate) {
		this.plate = plate;
	}

	public final String getBrand() {
		return brand;
	}

	public final void setBrand(String brand) {
		this.brand = brand;
	}

	public final String getColor() {
		return color;
	}

	public final void setColor(String color) {
		this.color = color;
	}

	public final List<Wheel> getWheels() {
		return wheels;
	}

}
