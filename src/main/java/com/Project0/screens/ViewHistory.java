package com.Project0.screens;

import com.Project0.daos.ReadAndWrite;
import java.util.Scanner;

public class ViewHistory implements Screen {
	
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		String history = ReadAndWrite.read(ReadAndWrite.fileNumber());
		String[] split = history.split(" ");
		System.out.println("Transaction History");
		if (split.length > 5)
		{
		 System.out.println("Date             Action           Resulting Balance");
		 for(int i = 0; i < split.length; i += 6)
		 {
			 System.out.println(split[i] + " " + split[i+1] + " " + split[i+2] + 
					" " + split[i+3] + "  " + split[i+4] + " " + split[i+5]);
		 }
		}
		else 
			System.out.println("Balance $" + split[split.length - 1]);
		int selection = 0;
		
		do {
			System.out.println("Please enter a number to select one of the following options:");
			System.out.println("Enter 1 to return to the Action Selection Screen");
			System.out.println("Enter 2 to log out");
			try {
			selection = scan.nextInt();
			switch (selection) {
			case 1:
				return new ActionSelect();
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
