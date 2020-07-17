 <%
 if(session.getAttribute("username")!=null)
 {
	 %>
	 <ul>
            <li><a href="home.jsp" class="current">Home</a></li>
            <!-- <li><a href="">Capture</a></li> -->
            <li><a href="send.jsp">Send Data</a></li>
            <li><a href="view.jsp">View Data</a></li>
            <li><a href="logout">Logout</a></li>
            
   </ul>  
	 
	 <%}else if(session.getAttribute("chusername")!=null)
	 {
		 %>
		 <ul>
	            <li><a href="chhome.jsp" class="current">Home</a></li>
	            <li><a href="viewnode.jsp">View Nodes</a></li>
	            
	            <li><a href="checkdataaggregation">Aggregate Data</a></li>
	            <li><a href="notification.jsp">Notification</a></li>
	            <li><a href="logout">Logout</a></li>
	            
	   </ul>  
	    <%
 }else if(session.getAttribute("username")==null){
 %>
 
 
 <ul>
            <li><a href="index.jsp" class="current">Home</a></li>
            <li><a href="register.jsp">Register</a></li>
            <li><a href="clusterhead.jsp">Cluster Head</a></li>
            <li><a href="about.jsp">About us</a></li>
            
   </ul> 
		 <%
	 } %>


