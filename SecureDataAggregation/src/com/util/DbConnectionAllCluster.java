package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionAllCluster 
{
	public static Connection getConnection(String PcName) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://"+PcName+":3306/dataaggregation","webmind","webmind");
		
		return con;
	}

}
