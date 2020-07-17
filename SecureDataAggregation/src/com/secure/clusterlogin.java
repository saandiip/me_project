package com.secure;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
import com.util.DbConnection;


public class clusterlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	 String username;
	   String password;
	   Connection con=null;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession(true);
		username=request.getParameter("username");
		password=request.getParameter("password");
		
		
		try {
			
			con=DbConnection.getConnection();
			GlobalFunction GF=new GlobalFunction();
			
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from chlogin where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				String node=rs.getString("username");
				
				
				String LocalPcName=InetAddress.getLocalHost().getHostName();
				int result=GF.ClusterHeadStatus(LocalPcName);
				
				if(result>0)
				{
					session.setAttribute("chusername", node);
					response.sendRedirect("chhome.jsp");
				}
				else
				{
					response.sendRedirect("clusterhead.jsp?notfound");
				}
				
				
				
			}
			else
			{
				response.sendRedirect("index.jsp?failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
