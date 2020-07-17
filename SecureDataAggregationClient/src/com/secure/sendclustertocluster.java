package com.secure;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.network.FileClient;
import com.util.DbConnection;
import com.util.DbConnectionAllCluster;


public class sendclustertocluster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String ClusterHead;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{
			ClusterHead=request.getParameter("cluster");
			FileClient FC=new FileClient();
			
			Connection con1=DbConnection.getConnection();
		     PreparedStatement ps1=con1.prepareStatement("select * from files where status='not compromised'");
		     ResultSet rs1=ps1.executeQuery();
		     while(rs1.next())
		     {
		    	 String filename=rs1.getString("filename");
		    	 String digest=rs1.getString("digest");
		    	 
		    	 FC.SendFile(filename, ClusterHead, digest);
		    	 
		     }
		     response.sendRedirect("dataaggregation.jsp?success");
			
			
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
