package com.secure;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;
import com.util.DbConnection;


public class checkdataaggregation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{
			 con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from files");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String weightage=rs.getString("weightage");
				String hweightage=rs.getString("hweightage");
				String filename=rs.getString("filename");
				String nodename=rs.getString("nodename");
				//System.out.println("original "+hweightage);

				if(StringUtils.isNullOrEmpty(rs.getString("hweightage")))
				{
					hweightage=weightage;
					//System.out.println("null check "+hweightage);
				}
				
				double wt=Double.parseDouble(weightage);
				double hwt=Double.parseDouble(hweightage);
				
				double low_weightage=wt-1;
				double high_weightage=wt+1;
				//System.out.println(hwt);
				if(hwt<=high_weightage && hwt>=low_weightage)
				{
					//System.out.println(filename+" not hacked");
					UpdateStatus("not compromised", filename, nodename);
				}
				else
				{
					//System.out.println(filename+" hacked");
					UpdateStatus("compromised", filename, nodename);
				}
			}
			response.sendRedirect("dataaggregation.jsp?done");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void UpdateStatus(String status,String filename,String nodename)
	{
		try 
		{
			PreparedStatement ps=con.prepareStatement("update files set status=? where filename=? and nodename=?");
			ps.setString(1, status);
			ps.setString(2, filename);
			ps.setString(3, nodename);
			ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
