package com.vehicles.project;

import java.util.Scanner;

public class HelpersMain {

	// General user input method, checks if user input is empty. If so, asks for
	// input again. Depending on vehicle type prompts carMessage or bikeMessage.
	public static String userInput(Scanner userInput, String vehicleType,
			String carMessage, String bikeMessage) {
		System.out.println(promptMessage(vehicleType, carMessage, bikeMessage));
		String userInputStr;
		while ((userInputStr = userInput.nextLine()).isEmpty()) {
			System.out.println("Not valid, input can not be empty!");
			System.out
				.println(promptMessage(vehicleType, carMessage, bikeMessage));
		}
		return userInputStr;
	}

	// General user input method, checks if user input is empty.
	// If so, asks for input again. Prompts default promptMessage.
	public static String userInput(Scanner userInput, String promptMessage) {
		return userInput(userInput, "car", promptMessage, "");
	}

	// User input method to enter string that can be converted to Double.
	// Checks if input string is empty or not numeric. If so, prompts
	// error message and asks for input again.
	public static String userInputNumeric(Scanner userInput,
			String promptMessage) {
		System.out.println(promptMessage);
		String userInputStr;
		while ((userInputStr = userInput.nextLine()).isEmpty()
			|| !HelpersMain.isNumeric(userInputStr)) {
			if (userInputStr.isEmpty()) {
				System.out.println("Not valid, input can not be empty!");
			} else {
				System.out.println("Not valid, numeric string is required!");
			}
			System.out.println(promptMessage);
		}
		return userInputStr;
	}

	// User input method to enter vehicle plate. If input is empty or does not
	// match expected pattern, prompts error message and asks for input again.
	// Depending on vehicle type prompts carMessage or bikeMessage.
	public static String userInputPlate(Scanner userInput, String vehicleType,
			String carMessage, String bikeMessage) {
		System.out.println(promptMessage(vehicleType, carMessage, bikeMessage));
		String userInputStr;
		while (((userInputStr = userInput.nextLine()).isEmpty())
			|| !HelpersMain.isValidPlate(userInputStr)) {
			if (userInputStr.isEmpty()) {
				System.out.println("Not valid, input can not be empty!");
			} else {
				System.out.println("Not valid, plate number must be 4 numbers"
					+ " followed by 2 or 3 letters!");
			}
			System.out
				.println(promptMessage(vehicleType, carMessage, bikeMessage));
		}
		return userInputStr.toUpperCase();
	}

	// User input method to enter vehicle plate. If input is empty or does not
	// match expected pattern, prompts error message and asks for input again.
	// Prompts default promptMessage.
	public static String userInputPlate(Scanner userInput,
			String promptMessage) {
		return userInputPlate(userInput, "car", promptMessage, "");
	}

	// User input method to enter vehicle wheel diameter. If input is empty or
	// does not match expected value, prompts error message and asks for input
	// again. Depending on vehicle type prompts carMessage or bikeMessage.
	public static String userInputDiameter(Scanner userInput,
			String vehicleType, String carMessage, String bikeMessage) {
		System.out.println(promptMessage(vehicleType, carMessage, bikeMessage));
		String userInputStr;
		while (((userInputStr = userInput.nextLine()).isEmpty())
			|| !HelpersMain.isValidDiameter(userInputStr)) {
			if (userInputStr.isEmpty()) {
				System.out.println("Not valid, input can not be empty!");
			} else {
				System.out.println("Not valid, diameter must be a numeric"
					+ " value > 0.4 and < 4!");
			}
			System.out
				.println(promptMessage(vehicleType, carMessage, bikeMessage));
		}
		return userInputStr;
	}

	// User input method to enter vehicle wheel diameter. If input is empty or
	// does not match expected value, prompts error message and asks for input
	// again. Prompts default promptMessage.
	public static String userInputDiameter(Scanner userInput, 
			String promptMessage) {
		return userInputDiameter(userInput, "car", promptMessage, "");
	}

	// User input method to choose vehicle type. If input does not match
	// expected value, prompts error message and asks for input again.
	public static String userInputType(Scanner userInput) {
		System.out.println("Do you want create a 'car' or a 'bike'?: ");
		String userInputStr;
		while (((userInputStr = userInput.nextLine()).isEmpty())
			|| ((!userInputStr.equalsIgnoreCase("car"))
				&& (!userInputStr.equalsIgnoreCase("bike"))
				&& (!userInputStr.equalsIgnoreCase("c"))
				&& (!userInputStr.equalsIgnoreCase("b")))) {
			if (userInputStr.isEmpty()) {
				System.out.println("Not valid, input can not be empty!");
				System.out.println("Do you want create a 'car' or a 'bike'?: ");
			} else {
				System.out
					.println("Not valid, please enter 'car' or 'bike'!: ");
			}
		}
		if (userInputStr.equalsIgnoreCase("c")) {
			userInputStr = "car";
		}
		if (userInputStr.equalsIgnoreCase("b")) {
			userInputStr = "bike";
		}
		return userInputStr.toLowerCase();
	}

	// Returns prompt message string depending on given vehicle type.
	public static String promptMessage(String vehicleType, String carMessage,
			String bikeMessage) {
		if (vehicleType.equals("car")) {
			return carMessage;
		}
		return bikeMessage;
	}

	// Checks if string content can be converted to Double type.
	public static boolean isNumeric(String stringToCheck) {
		try {
			Double.parseDouble(stringToCheck);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// Checks if given plate string pattern has 4 numbers followed
	// by 2 or 3 letters.
	public static boolean isValidPlate(String plate) {
		return plate.matches("\\d{4}[a-zA-Z]{2}")
			|| plate.matches("\\d{4}[a-zA-Z]{3}");
	}

	// Checks if given diameter string is numeric and, if so,
	// its value is > 0.4 and < 4.
	public static boolean isValidDiameter(String diameter) {
		return isNumeric(diameter) && Double.parseDouble(diameter) > 0.4
			&& Double.parseDouble(diameter) < 4;
	}

}
