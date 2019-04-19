package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPhase1 {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		String carPlate = HelpersMain.userInput(userInput,
				"Enter car plate number: ");
		String carBrand = HelpersMain.userInput(userInput, 
				"Enter car brand: ");
		String carColor = HelpersMain.userInput(userInput, 
				"Enter car color: ");
		String backWheelBrand = HelpersMain.userInput(userInput,
				"Enter back wheels brand: ");
		String backWheelDiameter = HelpersMain.userInputNumeric(userInput,
				"Enter back wheels diameter: ");
		String frontWheelBrand = HelpersMain.userInput(userInput,
				"Enter front wheels brand: ");
		String frontWheelDiameter = HelpersMain.userInputNumeric(userInput,
				"Enter front wheels diameter: ");
		userInput.close();

		Car myCar = new Car(carPlate, carBrand, carColor);

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
			myCar.addWheels(frontWheels, backWheels);
		} catch (Exception e) {
			// Prompts exception message depending on kind of error.
			e.printStackTrace();
		}

		// Print out vehicle properties.
		System.out.println();
		System.out.println(myCar);
	}

}
