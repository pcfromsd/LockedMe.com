package com.simplilearn.lockedme;

public class MenuOptions {

	public static void printWelcomeScreen (String orgName, String userName) {

		System.out.println("\n  Welcome, " + userName.toUpperCase() + " from " + orgName);
		
	}	

	public static void displayMainMenu () {

		System.out.println("");
		System.out.println("      1) Display current file names"); 
		System.out.println("      2) Perform Business Level Operations"); 
		System.out.println("      3) Close and Exit"); 
		
	}

	public static void displayBLOMenu () {

		System.out.println("");
		System.out.println("      1) Add a file"); 
		System.out.println("      2) Delete a file"); 
		System.out.println("      3) Search a file"); 
		System.out.println("      4) Go back to the previous menu"); 
		
	}
	
}
