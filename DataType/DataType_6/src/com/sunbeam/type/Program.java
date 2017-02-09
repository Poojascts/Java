package com.sunbeam.type;

public class Program
{
	public static void main(String[] args)
	{		
		String str = "A123";
		int number = Integer.parseInt(str);	//NumberFormatException
		System.out.printf("%-10d", number);	
	}
}
