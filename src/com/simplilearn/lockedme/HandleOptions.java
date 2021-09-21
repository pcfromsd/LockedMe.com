package com.simplilearn.lockedme;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.io.IOException;

public class HandleOptions {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
	FileOperation fileOp = new FileOperation();
   
	
	public void handleUserChoices() {

		try {
			final int MENU_FILE_NAMES = 1;
			final int MENU_BLO = 2;
			final int MENU_EXIT = 3;

			final int MENU_BLO_ADD = 21;
			final int MENU_BLO_DELETE = 22;
			final int MENU_BLO_SEARCH = 23;
			final int MENU_BLO_BACK = 24;

			int choice;
			boolean inLoop = false; 

			while (true) {
				
				if (inLoop) 
					MenuOptions.displayMainMenu();
				
				System.out.print("\n      Enter your choice: ");
				choice = Integer.parseInt(reader.readLine());
				
				if (choice == MENU_FILE_NAMES) { 
					fileOp.displayFiles("main");
				}
				else if (choice == MENU_BLO) { 

					while (true) {
					
						MenuOptions.displayBLOMenu();					

						System.out.print("\n      Enter your choice: ");
						choice = Integer.parseInt(reader.readLine()) + 20;
					
						if (choice == MENU_BLO_ADD) {
							System.out.print("          Enter filename (full path) to add: ");
							String fileName = reader.readLine();
							fileOp.addFile(fileName);
						}
						else if (choice == MENU_BLO_DELETE) {
							System.out.print("          Enter filename (full path) to delete: ");
							String fileName = reader.readLine();
							fileOp.deleteFile(fileName);
						}
						else if (choice == MENU_BLO_SEARCH) {
							fileOp.setSearchFileFound(false);
							System.out.print("          Enter filename to search: ");
							String fileName = reader.readLine();
							fileOp.searchFile(fileName, new File(fileOp.mainDir));
						}
						else if (choice == MENU_BLO_BACK) {
							break;
						}
						else {
							System.out.println("\nInvalid choice. Enter a valid choice.");
						}

					}
					
				}
				else if (choice == MENU_EXIT) {   
					System.out.println("Done.");
					reader.close();
					System.exit(0);
				}
				else {
					System.out.println("\nInvalid choice. Enter a valid choice.");
				}
				
				inLoop = true;
			}
		}
		catch (Exception e) {
			System.out.println("\nInvalid choice. Enter a valid choice.");
			MenuOptions.displayMainMenu();
			handleUserChoices();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
}
