package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPhase2 {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		String carPlate = userInputPlate(userInput, "Enter car plate number: ");
		String carBrand = userInput(userInput, "Enter car brand: ");
		String carColor = userInput(userInput, "Enter car color: ");
		String backWheelsBrand = userInput(userInput,
				"Enter back wheels brand: ");
		String backWheelsDiameter = userInputDiameter(userInput,
				"Enter back wheels diameter: ");
		userInput.close();
		String frontWheelsBrand = userInput(userInput,
				"Enter front wheels brand: ");
		String frontWheelsDiameter = userInputDiameter(userInput,
				"Enter front wheels diameter: ");

		Car myCar = new Car(carPlate, carBrand, carColor);

		Wheel rightBackWheel = new Wheel(backWheelsBrand,
				Double.parseDouble(backWheelsDiameter));
		Wheel leftBackWheel = new Wheel(backWheelsBrand,
				Double.parseDouble(backWheelsDiameter));
		Wheel rightFrontWheel = new Wheel(frontWheelsBrand,
				Double.parseDouble(frontWheelsDiameter));
		Wheel leftFrontWheel = new Wheel(frontWheelsBrand,
				Double.parseDouble(frontWheelsDiameter));

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

	// User input method to enter vehicle plate. If input does not match
	// expected pattern, prompts error message and asks for input again
	public static String userInputPlate(Scanner userInput,
			String promptMessage) {
		System.out.println(promptMessage);
		String userInputStr;
		while (((userInputStr = userInput.nextLine()).isEmpty())
				|| !isValidPlate(userInputStr)) {
			if (userInputStr.isEmpty()) {
				System.out.println("Not valid, input can not be empty!");
			} else {
				System.out.println("Not valid, plate number must be 4 numbers"
						+ " followed by 2 or 3 letters!");
			}
			System.out.println(promptMessage);
		}
		return userInputStr.toUpperCase();
	}

	// User input method to enter vehicle wheel diameter. If input does not
	// match expected value prompts error message and asks for input again
	public static String userInputDiameter(Scanner userInput,
			String promptMessage) {
		System.out.println(promptMessage);
		String userInputStr;
		while (((userInputStr = userInput.nextLine()).isEmpty())
				|| !isValidDiameter(userInputStr)) {
			if (userInputStr.isEmpty()) {
				System.out.println("Not valid, input can not be empty!");
			} else {
				System.out.println(
						"Not valid, diameter must be a numeric value > 0.4 and < 4");
			}
			System.out.println(promptMessage);
		}
		return userInputStr;
	}

	// Checks if given plate string pattern has 4 numbers followed by 2 or 3
	// letters
	public static boolean isValidPlate(String plate) {
		return plate.matches("\\d{4}[a-zA-Z]{2}")
				|| plate.matches("\\d{4}[a-zA-Z]{3}");
	}

	// Checks if given diameter string is numeric and, if so, its value is > 0.4
	// and < 4
	public static boolean isValidDiameter(String diameter) {
		return isNumeric(diameter) && Double.parseDouble(diameter) > 0.4
				&& Double.parseDouble(diameter) < 4;
	}

	// Checks if string content are digits so that later can be converted to
	// double type
	public static boolean isNumeric(String stringToCheck) {
		try {
			Double.parseDouble(stringToCheck);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
