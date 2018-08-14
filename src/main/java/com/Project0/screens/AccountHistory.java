package com.Project0.screens;

import java.util.Scanner;
import java.io.*;
import com.Project0.daos.ReadAndWrite;

public class AccountHistory implements Screen {

	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		// TODO Auto-generated method stub
		String history = "No account history";
		System.out.println("Enter an account number: ");
		System.out.println("Enter 0 to return to the previous screen");
		String number = scan.nextLine();
		if (number.equals("0"))
			return new AdminOptions();
		else
		{
			try {
			 history = ReadAndWrite.adminRead(number);
			} catch (FileNotFoundException fe) 
			 { System.out.println("Invalid Account Number");
			 return new AccountHistory();
			 }
		}
		
		String[] split = history.split(" ");
		System.out.println("Transaction History");
		System.out.println("Date             Action           Resulting Balance");
		try {
		for(int i = 0; i < split.length - 2; i += 6)
		{
			System.out.println(split[i] + " " + split[i+1] + " " + split[i+2] + 
					" " + split[i+3] + "  " + split[i+4] + " " + split[i+5]);
		}
		} catch (Exception e) 
		  { 
			System.out.println("Balance " + split[split.length - 1]);
		  }
		
		String selection;
		
		do {
			System.out.println("Please enter a number to select one of the following options:");
			System.out.println("Enter 1 to return to the Administrator Action Selection Screen");
			System.out.println("Enter 2 to log out");
			try {
			selection = scan.nextLine();
			switch (selection) {
			case "1":
				return new AdminOptions();
			case "2":
				return new StartScreen();
			default:
				break;
			}
			} catch (Exception exc) { return new AccountHistory(); }
		
		} while(!(selection.equals("1")) || !(selection.equals("2")) );
		
		return this;
	}
}
