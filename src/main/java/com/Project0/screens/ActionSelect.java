package com.Project0.screens;

import java.util.Scanner;
import com.Project0.screens.Screen;

public class ActionSelect implements Screen {
	
	private Scanner scan = new Scanner(System.in);
	int selection = 0;


	@Override
	public Screen start() {
		do {
			System.out.println("\tAction Selection");
			System.out.println("Please enter a number to select one of the following options:");
			System.out.println("Enter 1 to make a Deposit");
			System.out.println("Enter 2 to withdraw");
			System.out.println("Enter 3 to view your balance");
			System.out.println("Enter 4 to view your transaction history");
			System.out.println("Enter 5 to log out");
			selection = scan.nextInt();
			switch (selection) {
			case 1:
				return new DepositScreen();
			case 2:
				return new WithdrawScreen();
			case 3:
				return new ViewBalance();
			case 4:
				return new ViewHistory();
			case 5:
				return new StartScreen();
			default:
				break;
			}
		
		} while(selection != 1 || selection != 2 || selection != 3 || selection != 4
				|| selection != 5);

		return this;
	}

}
