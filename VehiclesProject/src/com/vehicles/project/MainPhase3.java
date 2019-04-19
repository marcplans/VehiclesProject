package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPhase3 {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		String vehicleType = HelpersMain.userInputType(userInput);
		String vehiclePlate = HelpersMain.userInputPlate(userInput, vehicleType,
			"Enter car plate number: ", "Enter bike plate number: ");
		String vehicleBrand = HelpersMain.userInput(userInput, vehicleType,
			"Enter car brand: ", "Enter bike brand: ");
		String vehicleColor = HelpersMain.userInput(userInput, vehicleType,
			"Enter car color: ", "Enter bike color: ");
		String backWheelBrand = HelpersMain.userInput(userInput, vehicleType,
			"Enter back wheels brand: ", "Enter back wheel brand: ");
		String backWheelDiameter = HelpersMain.userInputDiameter(userInput,	vehicleType, 
			"Enter back wheels diameter: ",	"Enter back wheel diameter: ");
		String frontWheelBrand = HelpersMain.userInput(userInput, vehicleType,
			"Enter front wheels brand: ", "Enter front wheel brand: ");
		String frontWheelDiameter = HelpersMain.userInputDiameter(userInput, vehicleType, 
			"Enter front wheels diameter: ", "Enter front wheel diameter: ");
		userInput.close();

		Vehicle myVehicle = null;

		if (vehicleType.equals("car")) {
			myVehicle = new Car(vehiclePlate, vehicleBrand, vehicleColor);

			Wheel rightBackWheel = new Wheel(backWheelBrand,
				Double.parseDouble(backWheelDiameter));
			Wheel leftBackWheel = new Wheel(backWheelBrand,
				Double.parseDouble(backWheelDiameter));
			Wheel rightFrontWheel = new Wheel(frontWheelBrand,
				Double.parseDouble(frontWheelDiameter));
			Wheel leftFrontWheel = new Wheel(frontWheelBrand,
				Double.parseDouble(frontWheelDiameter));

			List<Wheel> backWheels = new ArrayList<Wheel>();
			backWheels.add(rightBackWheel);
			backWheels.add(leftBackWheel);
			List<Wheel> frontWheels = new ArrayList<Wheel>();
			frontWheels.add(rightFrontWheel);
			frontWheels.add(leftFrontWheel);

			try {
				((Car) myVehicle).addWheels(frontWheels, backWheels);
			} catch (Exception e) {
				// Prompts exception message depending on kind of error.
				e.printStackTrace();
			}
		}

		if (vehicleType.equals("bike")) {
			myVehicle = new Bike(vehiclePlate, vehicleBrand, vehicleColor);
			Wheel frontWheel = new Wheel(frontWheelBrand,
				Double.parseDouble(frontWheelDiameter));
			Wheel backWheel = new Wheel(backWheelBrand,
				Double.parseDouble(backWheelDiameter));
			((Bike) myVehicle).addWheels(frontWheel, backWheel);
		}

		// Print out vehicle properties and object type.
		if (myVehicle != null) {
			System.out.println();
			System.out.println(myVehicle);
			System.out.println("---");
			System.out.println(
				"Object type: " + myVehicle.getClass().getSimpleName());
		}
	}

}
