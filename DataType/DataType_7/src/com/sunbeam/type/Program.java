package com.sunbeam.type;

public class Program
{
	public static void main(String[] args)
	{
		//Method names in Comment are abstract methods declared in Number class
		
		String strBoolean = "true";
		Boolean booleanRef = new Boolean(strBoolean); 
		boolean success = booleanRef.booleanValue();		//booleanValue
		System.out.printf("Boolean	:	%b\n\n", success);	//true
		
		String strByte = "123";
		Byte byteRef = new Byte(strByte);
		byte num1 = byteRef.byteValue();					//byteValue
		System.out.printf("Byte	:	%d\n\n", num1 );
		
		String strCharacter = "A";
		char ch = strCharacter.charAt(0);		//Look Here
		System.out.printf("Char	:	%c\n\n", ch);
		
		String strShort = "12345";
		Short shortRef = new Short(strShort);
		short num2 = shortRef.shortValue();					//shortValue
		System.out.printf("Short	:	%d\n\n", num2);
		
		String strInteger = "1234567";
		Integer integerRef = new Integer(strInteger);
		int num3 = integerRef.intValue();					//intValue
		System.out.printf("Integer	:	%d\n\n", num3);
		
		String strLong = "123456789";
		Long longRef = new Long(strLong);
		long num4 = longRef.longValue();					//longValue
		System.out.printf("Long	:	%d\n\n", num4);
		
		String strFloat = "12345.67";
		Float floatRef = new Float(strFloat);
		float num5 = floatRef.floatValue();					//floatValue
		System.out.printf("Float	:	%f\n\n", num5);
		
		String strDouble = "1234567.80";
		Double doubleRef = new Double(strDouble);
		double num6 = doubleRef.doubleValue();				//doubleValue
		System.out.printf("Double	:	%f\n\n", num6);
	}
}
