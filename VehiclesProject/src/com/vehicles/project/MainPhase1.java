package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPhase1 {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		String carPlate = userInput(userInput, "Enter car plate number: ");
		String carBrand = userInput(userInput, "Enter car brand: ");
		String carColor = userInput(userInput, "Enter car color: ");
		String backWheelBrand = userInput(userInput,
				"Enter back wheels brand: ");
		String backWheelDiameter = userInputNumeric(userInput,
				"Enter back wheels diameter: ");
		String frontWheelBrand = userInput(userInput,
				"Enter front wheels brand: ");
		String frontWheelDiameter = userInputNumeric(userInput,
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

		List<Wheel> frontWheels = new ArrayList<Wheel>();
		frontWheels.add(rightFrontWheel);
		frontWheels.add(leftFrontWheel);
		List<Wheel> backWheels = new ArrayList<Wheel>();
		backWheels.add(rightBackWheel);
		backWheels.add(leftBackWheel);

		try {
			myCar.addWheels(frontWheels, backWheels);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Print out vehicle properties
		System.out.println();
		System.out.println(myCar);
	}

	// General user input method, checks if user input is empty.
	// If so, asks for input again.
	public static String userInput(Scanner userInput, String promptMessage) {
		System.out.println(promptMessage);
		String userInputStr;
		while ((userInputStr = userInput.nextLine()).isEmpty()) {
			System.out.println("Not valid, input can not be empty!");
			System.out.println(promptMessage);
		}
		return userInputStr;
	}

	// User input method to enter vehicle plate, checks if input string is empty
	// or not numeric. If so, prompts error message and asks for input again
	public static String userInputNumeric(Scanner userInput,
			String promptMessage) {
		System.out.println(promptMessage);
		String userInputStr;
		while ((userInputStr = userInput.nextLine()).isEmpty()
				|| !isNumeric(userInputStr)) {
			if (userInputStr.isEmpty()) {
				System.out.println("Not valid, input can not be empty!");
			} else {
				System.out.println("Not valid, numeric string is required!");
			}
			System.out.println(promptMessage);
		}
		return userInputStr;
	}

	// Check if string content can be converted to Double
	public static boolean isNumeric(String stringToCheck) {
		try {
			Double.parseDouble(stringToCheck);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
