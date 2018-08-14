
package com.Project0.screens;

import java.util.Scanner;

public class AdminOptions implements Screen {

private Scanner scan = new Scanner(System.in);
	

	@Override
	public Screen start() {
		String entry = "";
		System.out.println("Administrator Actions");
		System.out.println("Type 1 to view all account holder's names and account numbers.");
		System.out.println("Type 2 to view an account's transaction history.");
		System.out.println("Type 3 to logout.");
		entry = scan.nextLine();
		
		switch(entry)
		{
		case "1":
			return new AccountNumbers();
		case "2":
			return new AccountHistory();
		case "3":
			return new StartScreen();
		default:
			return new AdminOptions(); 
			
		}
	
	}

}
