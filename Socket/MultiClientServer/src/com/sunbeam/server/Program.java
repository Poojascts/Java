package com.sunbeam.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

class CommunicationHandler implements Runnable
{
	private Thread thread;
	private Socket client;
	public CommunicationHandler( Socket client )
	{
		this.client = client;
		this.thread = new Thread(this);
		this.thread.start();
	}
	@Override
	public void run()
	{
		DataInputStream inputStream = null;
		DataOutputStream outputStream = null;
		BufferedReader reader = null;
		try
		{
			inputStream = new DataInputStream(client.getInputStream());
			outputStream = new DataOutputStream(client.getOutputStream());
			String text = "";
			reader = new BufferedReader(new InputStreamReader(System.in));
			do
			{
				System.out.print("Server	:	");
				text = reader.readLine();
				outputStream.writeUTF(text);
				outputStream.flush();
				
				text = inputStream.readUTF();
				System.out.println("Client	:	"+text);	
			}while( !( text.equals("end")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if( inputStream != null )
					inputStream.close();
				if(outputStream != null )
					outputStream.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
public class Program
{
	public static void main(String[] args)
	{
		ServerSocket server = null;
		try
		{
			final int port = 7500;	
			int count = 0;
			server = new ServerSocket(port);
			while( true )
			{				
				Socket client = server.accept();
				++ count;
				System.out.println("Client"+count+" connected.");
				Runnable r= new CommunicationHandler(client);
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				if( server != null )
					server.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
