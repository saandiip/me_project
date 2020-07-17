package com.network;


import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class FileClient {
	
	private Socket socket;
	
	public FileClient()
	{
		
	}
	
	public FileClient(String host, int port, String file,String filename,int size,String MyPcName,String digest) {
		try {
			InetAddress address = InetAddress.getByName(host);
			socket = new Socket(address, port);
			 
			 OutputStream os = socket.getOutputStream();
	            OutputStreamWriter osw = new OutputStreamWriter(os);
	            BufferedWriter bw = new BufferedWriter(osw);
	 
	            String number = filename;
	 
	            String sendMessage = number+"/"+size+"/"+MyPcName+"/"+digest+"\n";
	            bw.write(sendMessage);
	            bw.flush();
			sendFile(file,size);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		
	}
	
	public void sendFile(String file,int size) throws IOException {
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[size+2097152];
		
		
		
		while (fis.read(buffer) > 0) {
			dos.write(buffer);
		}
		
		fis.close();
		dos.close();	
	}
	
	/*public static void main(String[] args)*/ 
	public void SendFile(String filename,String PcName,String digest)
	{
		/*Client c=new Client();
		c.setfilename("aa.txt");*/
		try{
			//String filename="test2.txt";
			//String PcName="MASTER-PC";
		String path="C:\\ME_Project\\"+filename;
		File file=new File(path);
		int size=(int) file.length();
		System.out.println(size);
		String MyPcName=InetAddress.getLocalHost().getHostName();
		FileClient fc = new FileClient(PcName, 1988, path,filename,size,MyPcName,digest);
		System.out.println("done");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}