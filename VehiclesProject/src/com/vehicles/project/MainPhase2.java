package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPhase2 {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		String carPlate = HelpersMain.userInputPlate(userInput,
				"Enter car plate number: ");
		String carBrand = HelpersMain.userInput(userInput, 
				"Enter car brand: ");
		String carColor = HelpersMain.userInput(userInput, 
				"Enter car color: ");
		String backWheelsBrand = HelpersMain.userInput(userInput,
				"Enter back wheels brand: ");
		String backWheelsDiameter = HelpersMain.userInputDiameter(userInput,
				"Enter back wheels diameter: ");
		String frontWheelsBrand = HelpersMain.userInput(userInput,
				"Enter front wheels brand: ");
		String frontWheelsDiameter = HelpersMain.userInputDiameter(userInput,
				"Enter front wheels diameter: ");
		userInput.close();

		Car myCar = new Car(carPlate, carBrand, carColor);

		Wheel rightBackWheel = new Wheel(backWheelsBrand,
				Double.parseDouble(backWheelsDiameter));
		Wheel leftBackWheel = new Wheel(backWheelsBrand,
				Double.parseDouble(backWheelsDiameter));
		Wheel rightFrontWheel = new Wheel(frontWheelsBrand,
				Double.parseDouble(frontWheelsDiameter));
		Wheel leftFrontWheel = new Wheel(frontWheelsBrand,
				Double.parseDouble(frontWheelsDiameter));

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


