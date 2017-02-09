package com.sunbeam.reflection;

public class Program
{
	public static void main(String[] args)
	{
		//With the help of getClass method we can create instance of java.lang.Class class.
		
		String str = "Sandeep";
		
		Class<?> classRef = str.getClass();
		
		String className = classRef.getName();
		
		System.out.println("Class Name	:	"+className);
	}
}
