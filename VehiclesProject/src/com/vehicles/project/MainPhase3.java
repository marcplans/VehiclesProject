package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPhase3 {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		String vehicleType = userInputType(userInput);
		String vehiclePlate = userInputPlate(userInput, vehicleType,
			"Enter car plate number: ", "Enter bike plate number: ");
		String vehicleBrand = userInput(userInput, vehicleType,
			"Enter car brand: ", "Enter bike brand: ");
		String vehicleColor = userInput(userInput, vehicleType,
			"Enter car color: ", "Enter bike color: ");
		String frontWheelBrand = userInput(userInput, vehicleType,
			"Enter front wheels brand: ", "Enter front wheel brand: ");
		String frontWheelDiameter = userInputDiameter(userInput, vehicleType,
			"Enter front wheels diameter: ", "Enter front wheel diameter: ");
		String backWheelBrand = userInput(userInput, vehicleType,
			"Enter back wheels brand: ", "Enter back wheel brand: ");
		String backWheelDiameter = userInputDiameter(userInput, vehicleType,
			"Enter back wheels diameter: ", "Enter back wheel diameter: ");
		userInput.close();

		Vehicle myVehicle = null;

		if (vehicleType.equals("car")) {
			myVehicle = new Car(vehiclePlate, vehicleBrand, vehicleColor);

			Wheel rightFrontWheel = new Wheel(frontWheelBrand,
				Double.parseDouble(frontWheelDiameter));
			Wheel leftFrontWheel = new Wheel(frontWheelBrand,
				Double.parseDouble(frontWheelDiameter));
			Wheel rightBackWheel = new Wheel(backWheelBrand,
				Double.parseDouble(backWheelDiameter));
			Wheel leftBackWheel = new Wheel(backWheelBrand,
				Double.parseDouble(backWheelDiameter));

			List<Wheel> frontWheels = new ArrayList<Wheel>();
			frontWheels.add(rightFrontWheel);
			frontWheels.add(leftFrontWheel);
			List<Wheel> backWheels = new ArrayList<Wheel>();
			backWheels.add(rightBackWheel);
			backWheels.add(leftBackWheel);

			try {
				((Car) myVehicle).addWheels(frontWheels, backWheels);
			} catch (Exception e) { // TODO Auto-generated catch block
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

		// Print out vehicle properties 
		if (myVehicle != null) {
			System.out.println();
			System.out.println(myVehicle);
			System.out.println("---");
			System.out.println(
				"Object type: " + myVehicle.getClass().getSimpleName());
		}
	}

	// User input method to choose vehicle type,if input does not match
	// expected value prompts error message and asks again for input
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

	// General user input method, checks if user input is empty, if so, asks for
	// input again. Depending on vehicle type prompts carMessage or bikeMessage
	public static String userInput(Scanner userInput, String vehicleType,
		String carMessage, String bikeMessage) {
		System.out.println(promtMessage(vehicleType, carMessage, bikeMessage));
		String userInputStr;
		while ((userInputStr = userInput.nextLine()).isEmpty()) {
			System.out.println("Not valid, input can not be empty!");
			System.out
				.println(promtMessage(vehicleType, carMessage, bikeMessage));
		}
		return userInputStr;
	}

	// General user input method, checks if user input is empty, if so,
	// asks for input again. Replacement in promptMessage is not required,
	// so empty replacement string is passed
	public static String userInput(Scanner userInput, String promptMessage) {
		return userInput(userInput, "car", promptMessage, "");
	}

	// User input method to enter vehicle plate,if input does not match
	// expected pattern prompts error message and asks again for input
	public static String userInputPlate(Scanner userInput, String vehicleType,
		String carMessage, String bikeMessage) {
		System.out.println(promtMessage(vehicleType, carMessage, bikeMessage));
		String userInputStr;
		while (((userInputStr = userInput.nextLine()).isEmpty())
			|| !isValidPlate(userInputStr)) {
			if (userInputStr.isEmpty()) {
				System.out.println("Not valid, input can not be empty!");
			} else {
				System.out.println("Not valid, plate number must be 4 numbers"
					+ " followed by 2 or 3 letters!");
			}
			System.out
				.println(promtMessage(vehicleType, carMessage, bikeMessage));
		}
		return userInputStr.toUpperCase();
	}

	// User input method to enter vehicle wheel diameter, if input does not
	// match expected value prompts error message and asks again for input
	public static String userInputDiameter(Scanner userInput,
		String vehicleType, String carMessage, String bikeMessage) {
		System.out.println(promtMessage(vehicleType, carMessage, bikeMessage));
		String userInputStr;
		while (((userInputStr = userInput.nextLine()).isEmpty())
			|| !isValidDiameter(userInputStr)) {
			if (userInputStr.isEmpty()) {
				System.out.println("Not valid, input can not be empty!");
			} else {
				System.out.println(
					"Not valid, diameter must be a numeric value > 0.4 and < 4");
			}
			System.out
				.println(promtMessage(vehicleType, carMessage, bikeMessage));
		}
		return userInputStr;
	}

	// Checks if given plate string pattern has 4 numbers
	// followed by 2 or 3 letters
	public static boolean isValidPlate(String plate) {
		return plate.matches("\\d{4}[a-zA-Z]{2}")
			|| plate.matches("\\d{4}[a-zA-Z]{3}");
	}

	// Checks if given diameter string is numeric and, if so,
	// its value is > 0.4 and < 4
	public static boolean isValidDiameter(String diameter) {
		return isNumeric(diameter) && Double.parseDouble(diameter) > 0.4
			&& Double.parseDouble(diameter) < 4;
	}

	// Checks if string content are digits so that later it can be
	// converted to double type
	public static boolean isNumeric(String stringToCheck) {
		try {
			Double.parseDouble(stringToCheck);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// returns prompt message depending on vehicle type
	public static String promtMessage(String vehicleType, String carMessage,
		String bikeMessage) {
		if (vehicleType.equals("car")) {
			return carMessage;
		}
		return bikeMessage;
	}

}
