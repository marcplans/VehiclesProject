package com.vehicles.project;

import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		
		String mainStr = "fastfood";
		String subStr = "fOOd";
		System.out.println(mainStr.toLowerCase().contains(subStr.toLowerCase()));
		
//		Scanner userInput = new Scanner(System.in);
//		
//		Double userInputNum;
//		
//		System.out.println("Enter number: ");
//		while ((userInputNum = userInput.nextDouble()).isNaN()) {
//			System.out.println("Not valid!");
//		}
//		
//		
//		System.out.println("You typed: " + userInputNum);
		
		
//		String vehicleType = userInputType(userInput);
//
//		System.out.println("***");
//		System.out.println("Your vehicle is a: " + vehicleType);
//			
//		String newStr = "It is the best mobile you could get!";
//		
//		System.out.println(newStr.replaceAll("vehicle", vehicleType));
		
		
//		while(userInputStr = userInput.nextLine().isEmpty() || 
//				(!userInput.nextLine().equalsIgnoreCase("car")) ||
//				(!userInput.nextLine().equalsIgnoreCase("bike")) ||
//				(!userInput.nextLine().equalsIgnoreCase("c")) ||
//				(!userInput.nextLine().equalsIgnoreCase("b"))){
//	         System.out.println("Please enter 'car' or 'bike'");
				
				
//		System.out.println("Not valid, input is empty!");
//	    
//		}

//		userInput.close();	

		
		
		

		
//		String str1 = "abc";
//		String str2 = "abc";
//		
//		System.out.println(str1 == str2);
//		System.out.println(str1.equals(str2));
//		System.out.println(str1.equalsIgnoreCase(str2));
//
//		str1 = "abc";
//		str2 = "AbC";
//		
//		System.out.println();
//		System.out.println(str1 == str2);
//		System.out.println(str1.equals(str2));
//		System.out.println(str1.equalsIgnoreCase(str2));
//		
//		str1 = "abc";
//		str2 = str1;
//		
//		System.out.println();
//		System.out.println(str1 == str2);
//		System.out.println(str1.equals(str2));
//		System.out.println(str1.equalsIgnoreCase(str2));
//		
//		

		
		
		
		
//		String str = "8734SDFR";
//		
//		System.out.println(
//				str.matches("\\d{4}[a-zA-Z]{3}")
//				);
		
		


	}
	
	public static String userInputType(Scanner userInput) {
		System.out.println("Do you want create a 'car' or a 'bike'?: ");
		String userInputStr;
		while (((userInputStr = userInput.nextLine()).isEmpty()) ||	
				((!userInputStr.equalsIgnoreCase("car")) &&
				(!userInputStr.equalsIgnoreCase("bike")) &&
				(!userInputStr.equalsIgnoreCase("c")) &&
				(!userInputStr.equalsIgnoreCase("b")))){
			if (userInputStr.isEmpty()) {
				System.out.println("Not valid, input can not be empty!");
			} else {
				System.out.println("Please enter 'car' or 'bike'");
			}
		}
		if (userInputStr.equalsIgnoreCase("c")) {
			userInputStr = "car";
		} else if (userInputStr.equalsIgnoreCase("b")) {
			userInputStr = "bike";
		}
		return userInputStr.toLowerCase();
	}

	

	
	
	
	
	
	
	
	
	public static boolean isValidDiameter(String diameter) {
		return 
				Double.parseDouble(diameter) > 0.4 &&
				isNumeric(diameter) && 
				Double.parseDouble(diameter) < 4;
	}
	
	
	// check if string content are digits so that later can be converted to double type
	public static boolean isNumeric(String stringToCheck) {
		try {  
			Double.parseDouble(stringToCheck);  
			return true;
		} catch(NumberFormatException e){
			return false;    
		}  
	}

}




/*
 * 
 * // Checks if user input is empty and numeric, if so, asks for input again
 * public static String userInput(Scanner userInput, String promptMessage,
 * boolean checkNumeric) {
 * 
 * while (true) { System.out.println(promptMessage); String inputStr =
 * userInput.nextLine();
 * 
 * // Checks if input string is empty, if so back to loop start if
 * (inputStr.isEmpty()) { System.out.println("Not valid, input is empty!");
 * continue;
 * 
 * // Checks if numeric string is required, if not returns not empty input
 * string } else if (!checkNumeric) { return inputStr;
 * 
 * // Checks if string is numeric, if so returns not empty numeric input
 * string } else if (isNumeric(inputStr)) { return inputStr;
 * 
 * // Input string is not empty and not numeric, but numeric string is
 * required } else { System.out.println(
 * "Not valid, numeric string is required!"); } } }
 * 
 * 
 * // Checks if user input is empty, if so, asks for input again public
 * static String userInput(Scanner userInput, String promptMessage) { return
 * userInput(userInput, promptMessage, false); }
 * 
 */


/*	
// Checks if user input matches expected value. If not, prompts error and
// asks for new input
public static String userInput(Scanner userInput, String promptMessage,
	boolean checkPlate, boolean checkDiameter) {

	while (true) {
		System.out.println(promptMessage);
		String inputStr = userInput.nextLine();

		// Input string is empty, so jump back to loop start
		if (inputStr.isEmpty()) {
			System.out.println("Not valid, input is empty!");
			continue;

			// Input string is not empty and check plate and diameter
			// are not required, so base case input string is returned
		} else if (!checkPlate && !checkDiameter) {
			return inputStr;

			// Input string is not empty, check plate is required and string
			// matches expected plate format, so plate imput string is
			// returned
		} else if (checkPlate && isValidPlate(inputStr)) {
			return inputStr;

			// Input string is not empty, check plate is required and string
			// does not
			// match expected plate format, prompts error and jumps to loop
			// start
		} else if (checkPlate && !isValidPlate(inputStr)) {
			System.out.println(
				"Not valid, plate must be 4 numbers followed by 2 or 3 letters!");
			continue;

			// Input string is not empty, check diameter is required and
			// string
			// is a valid diameter value, so diameter input string is
			// returned
		} else if (checkDiameter && isValidDiameter(inputStr)) {
			return inputStr;

			// Input string is not empty, check diameter is required and
			// string
			// is not a valid diameter value, prompts error and jumps to
			// loop start
		} else if (checkDiameter && !isValidDiameter(inputStr)) {
			System.out.println(
				"Not valid, diameter must be a numeric value > 0.4 and < 4");
		}
	}
}

// Checks if user input is empty, if so, asks for input again
public static String userInput(Scanner userInput, String promptMessage) {
	return userInput(userInput, promptMessage, false, false);
}

// Checks if user input is empty, and takes checkOption boolean to check
// plate or diameter
// If checkOption is true checks plate format, if it is false checks wheel
// diameter string
public static String userInput(Scanner userInput, String promptMessage,
	boolean checkOption) {
	return userInput(userInput, promptMessage, checkOption, !checkOption);
}
*/
