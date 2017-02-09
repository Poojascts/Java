package com.sunbeam.reflection;

public class Program
{
	public static void main(String[] args)
	{
		//With the help of .class syntax we can create instance of java.lang.Class class.
		Class<?> classRef = String.class;
		
		String className = classRef.getName();
		
		System.out.println("Class Name	:	"+className);
	}
}
