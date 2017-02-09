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
		int num1 = ( int )Convert.changeType(args[0], int.class);
		
		float num2 = ( float )Convert.changeType(args[1], float.class);
		
		double result = num1 + num2;
		System.out.printf("Result	:	%f\n",result);
	}
}
