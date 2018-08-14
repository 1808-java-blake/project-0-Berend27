package com.Project0.screens;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.*;
import java.lang.StringBuffer;
import java.util.Scanner;
import com.Project0.daos.ReadAndWrite;

public class ViewBalance implements Screen {
	
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		// TODO Auto-generated method stub
		String already = "0.00";
		String file = ReadAndWrite.fileNumber();
		StringBuffer sb = new StringBuffer("C:\\Users\\Berend\\Documents\\Revature\\Week1\\Homework\\Project0\\src\\main\\resources\\users\\");
		sb.append(file + ".txt");
		file = sb.toString();
		try 
		{
			FileReader reader = new FileReader(file);
			BufferedReader rBuffer = new BufferedReader(reader);
			already = rBuffer.readLine();
			rBuffer.close();
		} catch (IOException e) { /* do nothing */ }
			
		double balance = 0;
		String[] split = already.split(" ");
		for (int i = 0; i < split.length; i++)
		{
			if (split[i].equals("Balance"))
			{
				balance = Double.parseDouble(split[i+1]);
				break;
			}
		}
		// Output
		System.out.println("Balance: $" + balance);
		
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
			} catch (Exception exc) { return new ViewBalance(); }
		
		} while(selection != 1 || selection != 2 );

		return this;
				/* creates a new text file, not needed for the view balance page
				try (ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream("src/main/resources/users/" + u.getBalance().toString() + ".txt"))) {

					oos.writeObject(u);

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
	}

}

