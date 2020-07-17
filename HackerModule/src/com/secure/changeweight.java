package com.secure;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DbConnection;

/**
 * Servlet implementation class changeweight
 */
public class changeweight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeweight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			Connection con=DbConnection.getConnection();
			String id=request.getParameter("hidden");
			String wt=request.getParameter("wt");
			
			PreparedStatement ps=con.prepareStatement("update files set hweightage=? where id=?");
			ps.setString(1, wt);
			ps.setString(2, id);
			ps.executeUpdate();
			
			response.sendRedirect("index1.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
