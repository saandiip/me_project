package com.secure;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import com.util.DbConnection;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String cookies = "1";
	public static String impdtm = "2";
	public static String impdtd = cookies+"4"; 
   String username;
   String password;
   Connection con=null;
   
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession(true);
		username=request.getParameter("username");
		password=request.getParameter("password");
		
		try {
			con=DbConnection.getConnection();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from node_info where node=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				String node=rs.getString("node");
				session.setAttribute("username", node);				
				response.sendRedirect("home.jsp");
				new LoadForm();
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
