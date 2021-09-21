package com.simplilearn.lockedme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets; 

public class FileOperation implements LockedMeInterface {

	final String baseDir = System.getProperty("user.dir");
	final String OS = System.getProperty("os.name").toLowerCase();
	public static String mainDir;
	
    private static Boolean searchFileFound;
	private static Boolean fileNotFoundMsg = false;
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

	
	
	public void setMainDir() {
		if (OS.indexOf("win") >= 0) {
			mainDir = baseDir + "\\main";
		}
		else if ((OS.indexOf("nix") >= 0) || (OS.indexOf("nux") >= 0) || (OS.indexOf("aix") >= 0)) {
			mainDir = baseDir + "/main";
		}
		else if (OS.indexOf("sunos") >= 0) {
			mainDir = baseDir + "/main";
		}
		else {
			mainDir = baseDir + "/main";
		}
	}
	
	
	public Boolean getSearchFileFound() {
		return searchFileFound;
	}
	
	public void setSearchFileFound(Boolean sff) {
		searchFileFound = sff;
	}
	
	public void createMainFolderIfNotPresent() throws Throwable {

		
		File file = new File(mainDir);

		try {
			if (!file.exists())  		
				file.mkdir();
			else if (!file.isDirectory()) 
				throw new Exception("\"main\" already exists and is not a directory.");
		}
		catch (Exception e) {
			throw e;
		}		
		finally {
		
		}
	}	
	
	public void displayFiles(String directoryName) {

		File dir = new File(directoryName);
		String[] files = dir.list();
		String absPath;

		try {
			if (files == null) {
				System.out.println( "Either dir does not exist or is not a directory");
			} 
			else { 
				if (files.length == 0) 
					System.out.println( "No files found in the directory \"" + directoryName + "\"");
				else {
					absPath = dir.getAbsolutePath();
					System.out.println("\n\nListing files under the folder "+ absPath);
					listFilesForFolder(dir);				
				}
			}
		}
		catch (Exception e) {
			throw e;
		}
		finally {
			
		}
		
	}
	

	public void listFilesForFolder(File folder) {

		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} 
			else {
				if (fileEntry.isFile()) {
					System.out.println("    " + fileEntry.getAbsolutePath());
				} 
			} 
		} 
	}					
	

	public void addFile(String fileName) {

		File file = new File(fileName);
		
		try {
				if (file.createNewFile()) {
					System.out.println("          File created");
				} 
				else {
					System.out.println("          File already exits");
				}		
				
				FileWriter writer = new FileWriter(fileName);

				System.out.print("          Enter text you want to write: ");
				String userInput = reader.readLine();
				writer.write(userInput);
				writer.close();
				System.out.println("          File written into");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}					

	
	public void deleteFile(String fileName) {

		File file = new File(fileName);
		
		try {
				if (file.delete()) {
					System.out.println("          File deleted");
				} 
				else {
					System.out.println("          File not found");
				}		
		}
		catch (Exception e) {
			
		}	      	      
	}					


	public void searchFile(String fileName, File folder) {

		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				searchFile(fileName, fileEntry);
			} 
			else {
				if (fileEntry.isFile()) {
					if (fileEntry.getName().equalsIgnoreCase(fileName)) {
						System.out.println("    " + fileEntry.getAbsolutePath());
		                FileOperation.searchFileFound = true;
					}
				} 
			} 
		} 
		if (!FileOperation.searchFileFound) {
			if (!FileOperation.fileNotFoundMsg) {
				System.out.println("File not found.....");
				FileOperation.fileNotFoundMsg = true;
			}
		}

	}					
	
	
}
