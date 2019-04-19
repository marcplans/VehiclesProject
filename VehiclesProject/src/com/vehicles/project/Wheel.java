package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

	// Added getters and setters.
	public final String getBrand() {
		return brand;
	}

	public final void setBrand(String brand) {
		this.brand = brand;
	}

	public final double getDiameter() {
		return diameter;
	}

	public final void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	// Added equals method to check if both wheels have same brand and diameter.
	public boolean equals(Wheel otherWheel) {
		return this.getBrand() == otherWheel.getBrand()
				&& this.getDiameter() == otherWheel.getDiameter();
	}

}


