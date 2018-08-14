package com.Project0.screens;

import java.util.Scanner;

public class AdminScreen implements Screen {
	
	private Scanner scan = new Scanner(System.in);
	

	@Override
	public Screen start() {
		String entry = "";
		System.out.println("Administrator Login");
		System.out.println("Type the correct password to login as an administrator.");
		System.out.println("Type 1 to return to the previous screen.");
		entry = scan.nextLine();
		
		switch(entry)
		{
		case "Java":
			return new AdminOptions();
		case "1":
			return new StartScreen();
		default:
			return new AdminScreen(); 
			
		}
	
	}

}
