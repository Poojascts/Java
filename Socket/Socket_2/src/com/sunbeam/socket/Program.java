package com.sunbeam.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Program
{
	public static void main(String[] args)
	{
		try
		{
		
			String hostName = "Soham";
			InetAddress address = InetAddress.getByName(hostName);
			String hostAddress = address.getHostAddress();
			System.out.printf("Host Address	:	%-15s\n", hostAddress);			
		} 
		catch (UnknownHostException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
