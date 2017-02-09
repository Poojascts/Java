package com.sunbeam.javap;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Program
{
	public static void printPackage( Package packageRef )
	{
		String packageName = packageRef.getName();
		System.out.printf("Package	:	%-20s\n", packageName);
		System.out.println("-----------------------------------------");
	}
	public static void printField( Field[] fields)
	{
		System.out.println("Field(s)	:");
		System.out.println("-----------------------------------------");
		for (Field field : fields)
		{
			int modifierValue = field.getModifiers();
			String modifierName = Modifier.toString(modifierValue);			
			String fieldType = field.getType().getName();			
			String fieldName = field.getName();
			System.out.printf("%-25s%-10s%-10s\n",modifierName, fieldType, fieldName);			
		}
		System.out.println("-----------------------------------------");
	}
	public static String getParameterDetails( Class<?>[] parameters )
	{
		StringBuilder strParameters = new StringBuilder();
		for (Class<?> parameter : parameters)
		{
			String parameterType = parameter.getSimpleName();
			strParameters.append(parameterType+",");
		}
		if( parameters.length > 0)
			return strParameters.substring(0, strParameters.length()-1);	//To remove last occurence of comma
		return strParameters.toString();
	}
	public static void printConstructor(Constructor<?>[] constructors )
	{
		System.out.println("Constructor(s)	:	");
		System.out.println("-----------------------------------------");
		for(Constructor<?> constructor : constructors)
		{
			String constructorName = constructor.getName();
			Class<?>[] parameters = constructor.getParameterTypes();
			String parameterDetails = Program.getParameterDetails(parameters);
			System.out.printf("%s(%s)\n",constructorName,parameterDetails);
		}
		System.out.println("-----------------------------------------");
	}
	public static void printMethod( Method[] methods )
	{
		System.out.println("Method(s)	:	");
		System.out.println("-----------------------------------------");
		for (Method method : methods)
		{
			String modifier = Modifier.toString(method.getModifiers());
			String returnType = method.getReturnType().getSimpleName();
			String methodName = method.getName();
			Class<?>[] parameters = method.getParameterTypes();
			String parameterDetails = Program.getParameterDetails(parameters);
			System.out.printf("%s %s %s(%s)\n",modifier,returnType,methodName,parameterDetails);
		}
		System.out.println("-----------------------------------------");
	}
	public static void main(String[] args)
	{
		try
		{
			String strClassName = args[0];
			Class<?> classRef = Class.forName(strClassName);
			//Package
			Package packageRef = classRef.getPackage();
			Program.printPackage(packageRef);
			//Fields
			Field[]fields = classRef.getDeclaredFields();
			Program.printField(fields);
			//Constructors
			Constructor<?>[] constructors = classRef.getDeclaredConstructors();
			Program.printConstructor(constructors);
			//Methods
			Method[] methods = classRef.getDeclaredMethods();
			Program.printMethod(methods);
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
