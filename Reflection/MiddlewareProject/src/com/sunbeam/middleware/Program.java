package com.sunbeam.middleware;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
class Convert
{
	public static Object changeType(String value, Class<?> parameterType )
	{
		switch( parameterType.getName() )
		{
			case "int":
				return Integer.parseInt(value);
			case "float":
				return Float.parseFloat(value);
			case "double":
				return Double.parseDouble(value);
		}
		return null;
	}
}
public class Program
{
	static BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
	public static void main(String[] args)
    {
		try
		{
			System.out.print("Enter fully qualified name of class	:	");
			String name = reader.readLine();
			Class<?> className =  Class.forName(name); 
			if( className != null )
			{
				Method[] methods = className.getMethods();
				
				System.out.print("Enter method name	:	");
				String methodName = reader.readLine();
				
				for (Method method : methods)
                {
	                if( method.getName().equals(methodName))
	                {
	                	Class<?>[] parameterTypes = method.getParameterTypes();
	                	int index = 0;
	                	Object[]arguments = new Object[ parameterTypes.length];
	                	for (Class<?> parameterType : parameterTypes)
                        {
	                		System.out.print("Enter value for the parameter of type "+parameterType.getName()+" : ");
	                		String argument = reader.readLine();
	                		arguments[ index ++ ] = Convert.changeType(argument, parameterType);
                        }
	                	Object object = className.newInstance();
	                	Object result = method.invoke(object , arguments);
	                	System.out.println("Result	:	"+result);
	                }
                }
			}
			else
				System.out.println("Class Not found");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
    }
}
