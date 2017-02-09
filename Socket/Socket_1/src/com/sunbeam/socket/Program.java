package com.sunbeam.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Program
{
	public static void main(String[] args)
	{
		try
		{
			InetAddress address = InetAddress.getLocalHost();
			
			String hostName = address.getHostName();
			System.out.printf("HostName	:	%-15s\n", hostName);
			
			String hostAddress = address.getHostAddress();
			System.out.printf("HostAddress	:	%-15s\n", hostAddress);
		} 
		catch (UnknownHostException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
