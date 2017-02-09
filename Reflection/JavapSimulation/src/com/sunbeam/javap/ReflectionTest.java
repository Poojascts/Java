package com.sunbeam.javap;
public class ReflectionTest
{
	private int num1;
	protected transient float num2;
	public static final double num3 = 20;
	public ReflectionTest()
	{
		this.num1 = 100;
		this.num2 = 200;
	}
	public ReflectionTest(int num1, int num2 )
	{
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int getNum1()
	{
		return num1;
	}
	public void setNum1(int num1)
	{
		this.num1 = num1;
	}
	public float getNum2()
	{
		return num2;
	}
	public void setNum2(float num2)
	{
		this.num2 = num2;
	}
	public static double getNum3()
	{
		return num3;
	}
	@Override
	public String toString()
	{
		return String.format("%-5d%-5d%-5d\n", this.num1, this.num2, this.num3);
	}
}
