package com.Project0.screens;

import java.util.Scanner;

import com.Project0.bean.User;
import com.Project0.daos.ReadAndWrite;
import com.Project0.daos.ZeroUserDao;
import com.Project0.screens.Screen;

public class StartScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private ZeroUserDao ud = ZeroUserDao.currentUserDao;
	boolean on = true;

	public Screen start() {
		String header = "\r\n" + 
				"\r\n" + 
				"d8888b. d88888b db    db d888888b d88888b d8888b.      d8888b.  .d8b.  d8b   db db   dD \r\n" + 
				"88  `8D 88'     `8b  d8' `~~88~~' 88'     88  `8D      88  `8D d8' `8b 888o  88 88 ,8P' \r\n" + 
				"88   88 88ooooo  `8bd8'     88    88ooooo 88oobY'      88oooY' 88ooo88 88V8o 88 88,8P   \r\n" + 
				"88   88 88~~~~~  .dPYb.     88    88~~~~~ 88`8b        88~~~b. 88~~~88 88 V8o88 88`8b   \r\n" + 
				"88  .8D 88.     .8P  Y8.    88    88.     88 `88.      88   8D 88   88 88  V888 88 `88. \r\n" + 
				"Y8888D' Y88888P YP    YP    YP    Y88888P 88   YD      Y8888P' YP   YP VP   V8P YP   YD \r\n" + 
				"                                                                                        \r\n" + 
				"                                                                                        \r\n" + 
				"\r\n" + 
				"";
		System.out.println(header);
		System.out.println("Enter your Username to log in.");
		System.out.println("Type new to sign up if you are new to this bank.");
		System.out.println("Type admin if to log in as an administrator");
		String username = scan.nextLine();
		if ("new".equalsIgnoreCase(username)) {
			return new ZeroRegisterUserScreen();
		}
		else if ("admin".equalsIgnoreCase(username))
		{
				// go to admin screen
				return new AdminScreen();
		}
		
		System.out.println("Enter Password: ");
		String password = scan.nextLine();

		User currentUser = ud.findByUsernameAndPassword(username, password);
		if (currentUser != null) {
			ReadAndWrite.updateCurrent(currentUser.getNumber());
			return new ActionSelect();
		}

		System.out.println("unable to login");
		return this;
	}
		
}
	// code to execute
		
		/*
		String selection;
		do {
		 System.out.println("Please choose from the following options:");
		 System.out.println("Enter 1 to log in");
		 System.out.println("Enter 2 to sign up if you are new to this bank");
		 System.out.println("Enter 3 if you are an admin");
		 selection = scan.nextLine();    // user input
		
		 switch (selection) {
		 case "1":
			 on = false;
		 	 // go to Log in Screen
			 return new LoginScreen();
		 case "2": 
			 // go to sign up screen
			 break;
		 case "3":
			 // go to admin screen
			 break;
		
		} 
		
		
	} while(selection != "1" || selection != "2" || selection != "3");
	*/

	
