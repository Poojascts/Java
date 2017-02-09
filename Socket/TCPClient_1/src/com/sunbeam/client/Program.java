package com.sunbeam.client;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Program
{
	public static void main(String[] args)
	{
		final int port = 7500;
		Socket client = null;
		DataInputStream inputStream = null;
		DataOutputStream outputStream = null;
		BufferedReader reader = null;
		try
		{
			InetAddress address = InetAddress.getLocalHost();
			client = new Socket(address, port);
			inputStream = new DataInputStream(client.getInputStream());
			outputStream = new DataOutputStream(client.getOutputStream());
			String text = "";
			reader = new BufferedReader(new InputStreamReader(System.in));
			do
			{
				text = inputStream.readUTF();				
				System.out.println("Server	:	"+text);
				
				System.out.print("Client	:	");
				text = reader.readLine();
				outputStream.writeUTF(text);
				outputStream.flush();					
			}while( !( text.equals("end")));
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				if( inputStream != null )
					inputStream.close();
				if(outputStream != null )
					outputStream.close();
				if( client != null )
					client.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
