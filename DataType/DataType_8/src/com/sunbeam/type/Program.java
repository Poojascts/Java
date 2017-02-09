package com.sunbeam.type;

class Convert
{
	public static Object changeType(String value, Class<?> dataType )
	{
		String dataTypeName = dataType.getName();
		switch(dataTypeName)
		{
			case "boolean":
				return Boolean.parseBoolean(value);
			case "byte":
				return Byte.parseByte(value);
			case "char":
				return value.charAt(0);
			case "short":
				return Short.parseShort(value);
			case "int":
				return Integer.parseInt(value);
			case "long":
				return Long.parseLong(value);
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
	public static void main(String[] args)
	{
		//Method names in Comment are abstract methods declared in Number class
		
		String strBoolean = "true";		 
		boolean success = (boolean)Convert.changeType(strBoolean, boolean.class);
		System.out.printf("Boolean	:	%b\n\n", success);	//true
		
		String strByte = "123";
		byte num1 = (byte)Convert.changeType(strByte, byte.class);
		System.out.printf("Byte	:	%d\n\n", num1 );
		
		String strCharacter = "A";
		char ch = (char)Convert.changeType(strCharacter, char.class);
		System.out.printf("Char	:	%c\n\n", ch);
		
		String strShort = "12345";
		short num2 = (short)Convert.changeType(strShort, short.class);
		System.out.printf("Short	:	%d\n\n", num2);
		
		String strInteger = "1234567";
		int num3 = (int)Convert.changeType(strInteger, int.class);
		System.out.printf("Integer	:	%d\n\n", num3);
		
		String strLong = "123456789";		
		long num4 = (long)Convert.changeType(strLong, long.class);					//longValue
		System.out.printf("Long	:	%d\n\n", num4);
		
		String strFloat = "12345.67";
		float num5 = (float)Convert.changeType(strFloat, float.class);
		System.out.printf("Float	:	%f\n\n", num5);
		
		String strDouble = "1234567.80";		
		double num6 = (double)Convert.changeType(strDouble, double.class);
		System.out.printf("Double	:	%f\n\n", num6);
	}
}
