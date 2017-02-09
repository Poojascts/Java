package com.sunbeam.reflection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* Create a new array, whose size and component type are not known until runtime, 
 and then modify the array's components*/

public class Program
{
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args)
	{
		try
		{
			System.out.print("Enter fully qualified name of element / component type	");
			String strComponentType = reader.readLine();
			Class<?> componentType = Class.forName(strComponentType);
			
			System.out.print("Enter length	:	");
			int length = Integer.parseInt(reader.readLine());
			
			//Create object of array
			Object arr = Array.newInstance(componentType, length);
			
			//set value inside array
			for( int index = 0 ; index < length; ++ index )
			{
				System.out.print("Enter element	:	");
				String element = reader.readLine();
				Constructor<?> constructor = componentType.getConstructor(String.class);
				Object value = constructor.newInstance(element);
				Array.set(arr, index, value);
			}
			
			//to print elements
			Object[] collection = ( Object[])arr;
			for (Object object : collection)
			{
				System.out.println(object);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		} 
		catch (SecurityException e)
		{
			e.printStackTrace();
		} 
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}		
	}
}
