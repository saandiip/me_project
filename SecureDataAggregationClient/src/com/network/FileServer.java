package com.network;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DbConnection;
import com.util.DbConnectionAllCluster;

public class FileServer extends Thread {
	
	private ServerSocket socket;
	
	public FileServer(int port) {
		try {
			socket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (true) {
			try {
				Socket clientSock = socket.accept();
				/*Server ss=new Server();
				
				String filename1=ss.getfilename();*/
				// socket = serverSocket.accept();
				
	                InputStream is = clientSock.getInputStream();
	                InputStreamReader isr = new InputStreamReader(is);
	                BufferedReader br = new BufferedReader(isr);
	               String  filename = br.readLine();
	                
	                System.out.println("Message received from client is "+filename);
	                String part[]=filename.split("/");
	                 filename=part[0];
	                String newfsize=part[1];
	                String Pcname=part[2];
	                String digest=part[3];
	                
	                String status=CheckDedup(digest);
	               // System.out.println("File Frome  "+Pcname);
	            
	                if(status.equals("true"))
	                {
	                	storedata(filename, Pcname, digest);	                
	                	int intfsize=Integer.parseInt(newfsize);	                
	                	saveFile(clientSock,filename,intfsize);
	                }
	                else if(status.equals("false"))
	                {
	                	String notifyfrom=InetAddress.getLocalHost().getHostName();
	                	//System.out.println("Already Present "+filename);
	                	int intfsize=Integer.parseInt(newfsize);
	                	saveFile1(clientSock,filename,intfsize);
	                	DedupData(filename, Pcname, notifyfrom);
	                	
	                }
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
		}
	}

	

	private void saveFile(Socket clientSock,String filename,int fsize) throws IOException {
		DataInputStream dis = new DataInputStream(clientSock.getInputStream());
		FileOutputStream fos = new FileOutputStream("C:\\ME_Project\\"+filename);
		byte[] buffer = new byte[fsize];
		
		int filesize = fsize; // Send file size in separate msg
		int read = 0;
		int totalRead = 0;
		int remaining = filesize;
		while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
			totalRead += read;
			remaining -= read;
			System.out.println("read " + totalRead + " bytes.");
			fos.write(buffer, 0, read);
		}
		
		fos.close();
		dis.close();
	}
	 
	
	public static void main(String[] args) {
		System.out.println("Server Starts");
		FileServer fs = new FileServer(1988);
		fs.start();
	}
	
	public void storedata(String filename,String pcname,String digest)
	{
		try {
			
			
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into clusterfiles(filename,digest,clustername) values(?,?,?)");
			ps.setString(1, filename);
			ps.setString(2, digest);
			ps.setString(3, pcname);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String CheckDedup(String digest)
	{
		String status = null;
		try 
		{
			
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from clusterfiles where digest=?");
			ps.setString(1, digest);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				status="false";
			}
			else
			{
				status="true";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
	
	private void saveFile1(Socket clientSock,String filename,int fsize) throws IOException {
		DataInputStream dis = new DataInputStream(clientSock.getInputStream());
		//FileOutputStream fos = new FileOutputStream("d:\\DataAggregation\\clusterfiles\\"+filename);
		byte[] buffer = new byte[fsize];
		
		int filesize = fsize; // Send file size in separate msg
		int read = 0;
		int totalRead = 0;
		int remaining = filesize;
		while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
			totalRead += read;
			remaining -= read;
			//System.out.println("read " + totalRead + " bytes.");
			//fos.write(buffer, 0, read);
			System.out.println("Already Present "+filename);
		}
		
		//fos.close();
		dis.close();
	}

	public void DedupData(String filename,String PcName, String notifyfrom)
	{
		try 
		{
			Connection con=DbConnectionAllCluster.getConnection(PcName);
			//DeleteData(notifyfrom);
			PreparedStatement ps=con.prepareStatement("insert into dedup_notification(filename,notifyfrom) values(?,?)");
			ps.setString(1, filename);
			ps.setString(2, notifyfrom);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void DeleteData(String PcName)
	{
		try 
		{
			Connection con=DbConnectionAllCluster.getConnection(PcName);
			PreparedStatement ps=con.prepareStatement("delete from dedup_notification where notifyfrom=?");
			ps.setString(1, PcName);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}