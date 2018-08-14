package com.Project0.screens;

import java.util.Scanner;

import com.Project0.bean.User;
import com.Project0.daos.ZeroUserDao;

import java.io.*;
import java.lang.StringBuffer;

public class ZeroRegisterUserScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private ZeroUserDao ud = ZeroUserDao.currentUserDao;
	private int number;
	String already;
	String file;
	double balance;

	@Override
	public Screen start() {
		User u = new User();
		System.out.println("Enter new username");
		u.setUsername(scan.nextLine());
		System.out.println("Enter password");
		u.setPassword(scan.nextLine());
		System.out.println("Enter first name");
		u.setFirstName(scan.nextLine());
		System.out.println("Enter last name");
		u.setLastName(scan.nextLine());
		try {
			FileReader reader1 = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\users\\accounts.txt");
		    BufferedReader rBuffer1 = new BufferedReader(reader1);
		    already = rBuffer1.readLine();
		    System.out.println(already);
		    rBuffer1.close();
		} catch (Exception e)
	    	{
			try {
			FileWriter writer1 = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\users\\accounts.txt");
		    BufferedWriter wBuffer1 = new BufferedWriter(writer1);
			// System.out.println("File reading problem");
		    already = null;
		    wBuffer1.write("current 1");
		    number = 1;
	    	u.setNumber(1);
	    	wBuffer1.close();
			} catch(Exception exc) { System.out.println("current 1 problem"); }
			}
	 try { 
		    FileWriter writer1 = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\users\\accounts.txt");
		    BufferedWriter wBuffer1 = new BufferedWriter(writer1);
		    if (already.equals(null))
		    {
		    	wBuffer1.write("current 1");
		    	u.setNumber(1);
		    	wBuffer1.close();
		    }
		    else 
		    {
		    	String[] split = already.split(" ");
		    	StringBuffer sb = new StringBuffer();
		    	for (int i = 0; i < split.length; i++)
		    	{
		    		if (split[i].equals("current"))
		    		{
		    			number = Integer.parseInt(split[i+1]) + 1;
		    			u.setNumber(number);
		    			split[i+1] = String.valueOf(number);
		    		}
		    		sb.append(split[i] + " ");
		    	}
		    	sb.append(u.getFirstName() + " " + u.getLastName() + " " + u.getUsername() + " ");
		    	sb.append(String.valueOf(number) + " ");
		    	wBuffer1.write(sb.toString());
		    	wBuffer1.close();
		    	
		    }
		    
		} catch (IOException ioe)
	    {
		      System.out.println("File problem");
		      
		} catch (NullPointerException exc)
	 	{
			try {
			FileWriter writer1 = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\users\\accounts.txt");
		    BufferedWriter wBuffer1 = new BufferedWriter(writer1);
			wBuffer1.write("current 1 " + u.getFirstName() + " " + u.getLastName() + " " + u.getUsername() + " 1");
	    	u.setNumber(1);
	    	wBuffer1.close();
			} catch (Exception ex) {  }
	 	}
		

		//System.out.println("Enter the starting account balance: $");
		//double balance = Double.parseDouble(scan.nextLine().replaceAll("$", ""));
		
			//u.setBalance(balance);
			ud.createUser(u);
			
		StringBuffer sb2 = new StringBuffer(System.getProperty("user.dir") + "\\src\\main\\resources\\users\\");
		sb2.append(number);
		sb2.append(".txt");
		file = sb2.toString();	
			
		try {	
		System.out.println("Enter an ammount of money to start the account with: ");
		balance = Double.parseDouble(scan.nextLine());
		FileWriter writer = new FileWriter(file);
	     BufferedWriter buffer = new BufferedWriter(writer);
	     StringBuffer sb3 = new StringBuffer("Balance ");
	     if (balance < 0)
		 {
			balance = 0.00;
		 } 
	     sb3.append(balance);
	     sb3.append(" ");
	     String text = sb3.toString();
	     buffer.write(text);
	     buffer.close();
		 
		} catch (Exception e) 
	 	{ 
			balance = 0.00;
			try {
			FileWriter writer = new FileWriter(file);
		    BufferedWriter buffer = new BufferedWriter(writer);
		    StringBuffer sb4 = new StringBuffer("Balance ");
			sb4.append(balance);
		    sb4.append(" ");
		    String text = sb4.toString();
		    buffer.write(text);
		    buffer.close();
			return new DepositScreen(); 
			} catch (Exception exc) { return new DepositScreen(); }
		}
		
		return new StartScreen();
	}

}
