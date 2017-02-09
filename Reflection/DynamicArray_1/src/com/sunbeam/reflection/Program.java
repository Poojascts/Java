package com.sunbeam.reflection;
import java.lang.reflect.Field;
public class Program
{
	public static void main(String[] args)
	{
		try
		{
			String strClassName = "java.lang.Throwable";
			Class<?> classRef = Class.forName(strClassName);
			Field[] fields = classRef.getDeclaredFields();
			boolean found = false;
			for (Field field : fields)
			{
				if( field.getType().isArray())
				{
					found = true;
					String fieldName = field.getName();
					Class<?> fieldType = field.getType();
					Class<?> componentType = fieldType.getComponentType();
					System.out.printf("%-20s%-20s%-20s\n",fieldName, fieldType.getSimpleName(), componentType.getSimpleName());
				}
			}
			if( !found )
				System.out.println("No array field.");
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
