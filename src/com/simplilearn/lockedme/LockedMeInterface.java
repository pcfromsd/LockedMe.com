package com.simplilearn.lockedme;

import java.io.File;

public interface LockedMeInterface
{
	public void displayFiles(String directoryName);
	public void listFilesForFolder(File folder);	
	public void addFile(String fileName);
	public void deleteFile(String fileName);
	public void searchFile(String fileName, File dirF);	
}
