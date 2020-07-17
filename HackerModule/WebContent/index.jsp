<!DOCTYPE html>
<%@page import="com.util.DbConnection"%>
<%@page import="java.net.InetAddress"%>
<%@page import="com.util.DBConnectionServer"%>
<%@page import="java.sql.*"%>
<html>
<head>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<meta charset="UTF-8">

<title></title>
<link href="tooplate_style.css" rel="stylesheet" type="text/css" />
<style>
body {
    background: url('images/mt.gif') no-repeat fixed center center;
    background-size: cover;
    font-family: Montserrat;
}

.logo {
    width: 213px;
    height: 36px;
    background: url() no-repeat;
    margin: 30px auto;
}

.login-block {
    width: 320px;
    padding: 20px;
    background: #fff;
    border-radius: 5px;
    border-top: 5px solid #ff656c;
    margin: 0 auto;
}

.login-block h1 {
    text-align: center;
    color: #000;
    font-size: 18px;
    text-transform: uppercase;
    margin-top: 0;
    margin-bottom: 20px;
}

.login-block input {
    width: 100%;
    height: 42px;
    box-sizing: border-box;
    border-radius: 5px;
    border: 1px solid #ccc;
    margin-bottom: 20px;
    font-size: 14px;
    font-family: Montserrat;
    padding: 0 20px 0 50px;
    outline: none;
}

.login-block input#username {
    background: #fff url('images/u0XmBmv.png') 20px top no-repeat;
    background-size: 16px 80px;
}

.login-block input#username:focus {
    background: #fff url('images/u0XmBmv.png') 20px bottom no-repeat;
    background-size: 16px 80px;
}

.login-block input#password {
    background: #fff url('images/Qf83FTt.png') 20px top no-repeat;
    background-size: 16px 80px;
}

.login-block input#password:focus {
    background: #fff url('images/Qf83FTt.png') 20px bottom no-repeat;
    background-size: 16px 80px;
}

.login-block input:active, .login-block input:focus {
    border: 1px solid #ff656c;
}

.button {
    width: 100%;
    height: 40px;
    background: #ff656c;
    box-sizing: border-box;
    border-radius: 5px;
    border: 1px solid #e15960;
    color: #fff;
    font-weight: bold;
    text-transform: uppercase;
    font-size: 14px;
    font-family: Montserrat;
    outline: none;
    cursor: pointer;
}

.login-block button:hover {
    background: #ff7b81;
}

</style>
</head>

<body>

<div id="tooplate_wrapper">
<div id="tooplate_header">
	        <div >
	      
	        </div>
	         
       <div >
       	<div id="tooplate_content">
           		
                <div class="post_box_right">
                        <h2>Welcome Cluster Head </h2>

     <table cellpadding="1" cellspacing="20" bgcolor="black">
     <tr>
     <td>SrNo</td>
     <td>Node</td>
     <td>Files</td>
     <td>Status</td>
     
     </tr>
     <%
     int snno=1;
     Connection con1=DbConnection.getConnection();
     PreparedStatement ps1=con1.prepareStatement("select * from files");
     ResultSet rs1=ps1.executeQuery();
     while(rs1.next())
     {
    	 %>
    	 <form action="changeweight" method="post">
    	 <tr style="color: white;">
    	 <td><%=snno++ %></td>
    	 <td><%=rs1.getString("nodename") %></td>
    	 <td><%=rs1.getString("filename") %></td>
    	
    	 <td><input type="text" name="wt" value="<%=rs1.getString("weightage") %>" style="width: 40px"></td> 
    	 <td><input type="hidden" name="hidden" value="<%=rs1.getString("id") %>"></td>  
    	 <td><input type="submit" value="Change"></td>  	 
    	</form>
    	
    		 <%
    	 
     }
     
     %>
     </tr>
          </table>
                        </div> 	
    </div>
    </div></div>

</div>


</body>

</html>