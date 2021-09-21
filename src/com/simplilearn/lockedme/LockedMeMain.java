package com.simplilearn.lockedme;

public class LockedMeMain {

	public static void main(String[] args) throws Throwable {

		FileOperation fo = new FileOperation();
		HandleOptions ho = new HandleOptions();
		
		try {
			// Set the "main" directory path based on OS
			fo.setMainDir();
			
			// Create "main" folder if not present in current folder structure
			fo.createMainFolderIfNotPresent();
		
			// Display welcome screen
			MenuOptions.printWelcomeScreen("LockedMe.com", "Purnendu Chakraborty");
			
			// Display menu and handle user inputs in a loop until user chose to "exit"			
			MenuOptions.displayMainMenu();
			ho.handleUserChoices();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
