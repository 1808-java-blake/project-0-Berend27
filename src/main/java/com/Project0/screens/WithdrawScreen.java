package com.Project0.screens;

import java.util.Scanner;

import com.Project0.daos.ZeroUserDao;
import com.Project0.daos.ReadAndWrite;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;
import java.lang.StringBuilder;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WithdrawScreen implements Screen {
	
			
	private Scanner scan = new Scanner(System.in);
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
	
	@Override
	public Screen start() {
		double wAmmount = 0;
		double balance = 0;
		String file = ReadAndWrite.fullFileName();
		try {
		System.out.println("Enter an ammount to withdraw: ");
		System.out.print("$");
		wAmmount = Double.parseDouble(scan.nextLine());
		if (wAmmount < 0)
			return new WithdrawScreen();
		} catch (Exception e) { return new WithdrawScreen(); }

				// TODO Auto-generated method stub
				String already = "0.00";
				try 
				{
					FileReader reader = new FileReader(file);
					BufferedReader rBuffer = new BufferedReader(reader);
					already = rBuffer.readLine();
					rBuffer.close();
				} catch (IOException e) { /* do nothing */ }
					
				String[] split = already.split(" ");
				for (int i = 0; i < split.length; i++)
				{
					if (split[i].equals("Balance"))
					{
						balance = Double.parseDouble(split[i+1]);
						if (wAmmount > balance || balance == 0)
						{
							System.out.println("Insufficient funds for withdrawal");
							System.out.println("Balance: $" + balance);
							int choice = 0;
							
							do {
								System.out.println("Please enter a number to select one of the following options:");
								System.out.println("Enter 1 to return to the Action Selection Screen");
								System.out.println("Enter 2 to log out");
								System.out.println("Enter 3 to try another withdrawal");
								try {
								choice = scan.nextInt();
								switch (choice) {
								case 1:
									return new ActionSelect();
								case 2:
									return new StartScreen();
								case 3:
									return new WithdrawScreen();
								default:
									break;
								}
								} catch (Exception exc) { return new ViewBalance(); }
							
							} while(choice != 1 || choice != 2 || choice != 3);
							
						}
						balance -= wAmmount;
						break;
					}
					
				}
				
				try {
				     FileWriter writer = new FileWriter(file);
				     BufferedWriter buffer = new BufferedWriter(writer);
				     StringBuilder sb = new StringBuilder("Balance ");
				     sb.append(balance);
				     sb.append(" ");
				     sb.append(already);
				     String text = sb.toString();
				     buffer.write(text);
				     buffer.close();
				    } catch (IOException e)
				    {
				      System.out.println("File problem");
				    }
				 
				
				// Taking record of the withdrawal
				LocalDateTime thisTime = LocalDateTime.now();
				StringBuffer sb2 = new StringBuffer(dtf.format(thisTime) + " ");
				sb2.append("Withdrawal ");
				sb2.append(wAmmount);
				ReadAndWrite.writeToFront(sb2.toString());
				
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


		return new ActionSelect();

	}
}