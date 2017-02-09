package com.sunbeam.reflection;

public class Program
{
	public static void main(String[] args)
	{
		//With the help of Class.forName method we can create instance of java.lang.Class class.
		
		try
		{
			Class<?> classRef = Class.forName("java.lang.String");
			
			String className = classRef.getName();
			
			System.out.println("Class Name	:	"+className);
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
