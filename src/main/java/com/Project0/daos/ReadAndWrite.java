package com.Project0.daos;
// Utility class for reading to and writing from text files
// Includes a method for finding the current user's account number
// Reads from the file first to preserve existing content, then writes to it.
// Reads from the file a second time to show the new contents of the file. 

import java.io.*;
import java.lang.StringBuffer;


public class ReadAndWrite {
	
	public static void writeToFront(String text)
	{
		String already = "";
		try 
		{
			FileReader reader = new FileReader(ReadAndWrite.fullFileName());
			BufferedReader rBuffer = new BufferedReader(reader);
			already = rBuffer.readLine();
			rBuffer.close();
		} catch (IOException ioe) { System.out.println("File reading problem"); }
		
		// Writing to the front of the file's text
		try {
			StringBuffer sb = new StringBuffer(text + " ");
			sb.append(already);
			FileWriter writer = new FileWriter(ReadAndWrite.fullFileName());
			BufferedWriter wBuffer = new BufferedWriter(writer);
			wBuffer.write(sb.toString());
			wBuffer.close();
		} catch (Exception e) { System.out.println("Problem writing to file"); }
		
	}
	
	public static void write (String file, String text)
	  {
	    StringBuffer sb = new StringBuffer(System.getProperty("user.dir") + "\\src\\main\\resources\\users\\");
	    sb.append(file);
	    sb.append(".txt");
	    file = sb.toString();
	    
	    try {
	     FileReader reader1 = new FileReader(file);
	     BufferedReader rBuffer1 = new BufferedReader(reader1);
	     String already = rBuffer1.readLine();
	     rBuffer1.close();
	     StringBuffer sb2 = new StringBuffer(already);
	     sb2.append(" ");
	     sb2.append(text);
	     text = sb2.toString();
	    } catch (IOException e)
	    {
	      System.out.println("File reading problem");
	    }
	    
	    try {
	     FileWriter writer = new FileWriter(file);
	     BufferedWriter buffer = new BufferedWriter(writer);
	     buffer.write(text);
	     buffer.close();
	    } catch (IOException e)
	    {
	      System.out.println("File writing problem");
	    }
	  }
	  
	  public static String read (String file) 
	  {
	    StringBuffer sb = new StringBuffer(System.getProperty("user.dir") + "\\src\\main\\resources\\users\\");
	    sb.append(file);
	    sb.append(".txt");
	    file = sb.toString();
	    String text = "";
	    
	    try {
	     FileReader reader = new FileReader(file);
	     BufferedReader rBuffer = new BufferedReader(reader);
	     text = rBuffer.readLine();
	     rBuffer.close();
	     System.out.println(text);
	    } catch (Exception e)
	    {
	      System.out.println("File reading problem");
	    }
	    return text;
	  }
	  
	  public static String adminRead (String file) throws FileNotFoundException
	  {
	    // StringBuffer sb = new StringBuffer("C:\\Users\\Berend\\Documents\\Revature\\Week1\\Homework\\Project0\\src\\main\\resources\\users\\");
	    StringBuffer sb = new StringBuffer(System.getProperty("user.dir") + "\\src\\main\\resources\\users\\");
		sb.append(file);
	    sb.append(".txt");
	    file = sb.toString();
	    String text = "";
	    
	    try {
	     FileReader reader = new FileReader(file);
	     BufferedReader rBuffer = new BufferedReader(reader);
	     text = rBuffer.readLine();
	     rBuffer.close();
	     System.out.println(text);
	    } //catch (FileNotFoundException fe) { throw (fe);}
	     catch (IOException e)
	    {
	      System.out.println("File reading problem");
	    }
	    return text;
	  }
	  
	  public static String fileNumber ()
	  {
		  String number = "1";
		  try {
			  FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\users\\accounts.txt");
			  BufferedReader rBuffer = new BufferedReader(reader);
			  String[] split = rBuffer.readLine().split(" ");
			  rBuffer.close();
			  for (int i = 0; i < split.length; i++)
			  {
				  if (split[i].equals("current"))
				  {
					  number = split[i + 1];
					  break;
				  }
			  }
		  	} catch (Exception e) { }
		  return number;
	  }
	  
	  public static String fullFileName()
	  {
		  String name;
		  String number = "1";
		  try {
			  FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\users\\accounts.txt");
			  BufferedReader rBuffer = new BufferedReader(reader);
			  String[] split = rBuffer.readLine().split(" ");
			  rBuffer.close();
			  for (int i = 0; i < split.length; i++)
			  {
				  if (split[i].equals("current"))
				  {
					  number = split[i + 1];
					  break;
				  }
			  }
		  	} catch (Exception e) { }
		  
		  StringBuffer sb = new StringBuffer(System.getProperty("user.dir") + "\\src\\main\\resources\\users\\");
		  sb.append(number + ".txt");
		  name = sb.toString();
		  return name;
	  }
	  
	
	public static void updateCurrent(int accountNumber) 
	{
		String accounts = " ";
		try {
			FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\users\\accounts.txt");
			BufferedReader rBuffer = new BufferedReader(reader);
			accounts = rBuffer.readLine();
			rBuffer.close();
		} catch (IOException e) 
			{ System.out.println("Couldn't access account numbers file."); }
		
		try {
			FileWriter writer = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\users\\accounts.txt");
		    BufferedWriter wBuffer1 = new BufferedWriter(writer);
		    String[] split = accounts.split(" ");
	    	StringBuffer sb = new StringBuffer();
	    	for (int i = 0; i < split.length; i++)
	    	{
	    		if (split[i].equals("current"))
	    		{
	    			int number = accountNumber;
	    			split[i+1] = String.valueOf(number);
	    		}
	    		sb.append(split[i] + " ");
	    	}
	    	wBuffer1.write(sb.toString());
	    	wBuffer1.close();
		} catch (Exception e)
		{
			System.out.println("Problem updating the current account number");
		}
		
	}

}
