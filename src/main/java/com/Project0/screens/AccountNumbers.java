package com.Project0.screens;

import java.util.Scanner;

import com.Project0.daos.ReadAndWrite;

public class AccountNumbers implements Screen {

	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		// TODO Auto-generated method stub
		String numbers = "";
		try {
		 numbers = ReadAndWrite.adminRead("accounts");
		} catch (Exception e) { /* nothing there */ }
		String[] split = numbers.split(" ");
		System.out.println("Account Numbers");
		System.out.println("Name       Username  Account Number");
		if (split.length > 3)
		{
		 for(int i = 2; i < split.length; i += 4)
		 {
		 	System.out.println(split[i] + " " + split[i+1] + " " + split[i+2] + "   " + split[i+3]);
		 }
		}
		int selection = 0;
		
		do {
			System.out.println("Please enter a number to select one of the following options:");
			System.out.println("Enter 1 to return to the Administrator Actions Screen");
			System.out.println("Enter 2 to log out");
			try {
			selection = scan.nextInt();
			switch (selection) {
			case 1:
				return new AdminOptions();
			case 2:
				return new StartScreen();
			default:
				break;
			}
			} catch (Exception exc) { return new ViewHistory(); }
		
		} while(selection != 1 || selection != 2 );
		
		return this;
	}

}
