package com.network;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;

import com.secure.GlobalFunction;
 
public class NetworkPing {
 
	
	public static void main(String[] args) throws IOException {
 
		InetAddress localhost = InetAddress.getLocalHost();
	String localPcName=	localhost.getLocalHost().getHostName();
	GlobalFunction GF = null;
	
	try {
		 GF=new GlobalFunction();
		GF.DeleteAllFiles("server_chlogin");
		GF.AllClusterHead(localPcName);
	}  catch (Exception e) {
		
		e.printStackTrace();
	}
	
	
		byte[] ip = localhost.getAddress();
 
		for (int i = 1; i <= 254; i++)
		{
			ip[3] = (byte)i;
			InetAddress address = InetAddress.getByAddress(ip);
		
		 if (!address.getHostAddress().equals(address.getHostName()))
		{
			//System.out.println(address + " machine is known in a DNS lookup");
			
			String str=address.toString();
			String parts[]=str.split("/");
			//System.out.println(parts[0]);
			
			GF.AllClusterHead(parts[0]);
		}
		
		}
 
	}
}