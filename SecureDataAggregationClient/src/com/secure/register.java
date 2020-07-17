package com.secure;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.mysql.jdbc.PreparedStatement;
import com.util.DbConnection;

/**
 * Servlet implementation class register
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    String node;
    String password;
    String cpassword;
    Connection con=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		node=request.getParameter("node");
		password=request.getParameter("password");
		cpassword=request.getParameter("cpassword");
		
		try {
			
			if(password.equals(cpassword))
			{
				con=DbConnection.getConnection();
				PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into node_info(node,password) values(?,?)");
				ps.setString(1, node);
				ps.setString(2, password);
				int result=ps.executeUpdate();
				
				if(result>0)
				{
					response.sendRedirect("index.jsp?success");
				}
			}
			else
			{
				response.sendRedirect("register.jsp?incorrect");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
