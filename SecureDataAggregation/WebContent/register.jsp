<%@page import="java.text.Format"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><%@include file="title1.jsp" %></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<!--
Template 2030 Elegant
http://www.tooplate.com/view/2030-elegant
-->
<!-- <link href="js/jquery.datepick.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/jquery.plugin.js"></script>
<script src="js/jquery.datepick.js"></script>




<script>
$(function() {
	$('#dob').datepick();
	$('#inlineDatepicker').datepick({onSelect: showDate});
});

function showDate(date) {
	alert('The date chosen is ' + date);
}
</script> -->


<link href="tooplate_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.nivo.slider.js" type="text/javascript"></script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>


<script type="text/javascript">
$(window).load(function() {
	$('#slider').nivoSlider({
		effect:'random',
		slices:15,
		animSpeed:500,
		pauseTime:3000,
		startSlide:0, //Set starting Slide (0 index)
		directionNav:false, 
		directionNavHide:false, //Only show on hover
		controlNav:false, //1,2,3...
		controlNavThumbs:false, //Use thumbnails for Control Nav
		pauseOnHover:true, //Stop animation while hovering
		manualAdvance:false, //Force manual transitions
		captionOpacity:0.8, //Universal caption opacity
		beforeChange: function(){},
		afterChange: function(){},
		slideshowEnd: function(){} //Triggers after all slides have been shown
	});
});
</script>
 <script type="text/javascript">
function loadXMLDoc()
{
	
var xmlhttp;
var k=document.getElementById("node").value;
var urls="pass.jsp?ver="+k;
 
if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();
  }
else
  {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4)
    {
        
        var ss=xmlhttp.responseText;
        if(ss.match("Name already taken"))
        	{
        	document.getElementById("mySubmit").disabled = true;
        	document.getElementById("err").innerHTML=xmlhttp.responseText;
        	}
        if(document.getElementById("node").value==null || document.getElementById("node").value=="")
        	{
        	
        	document.getElementById("err").innerHTML=" ";
        	}
        else{
        	document.getElementById("mySubmit").disabled = false;
      	  document.getElementById("err").innerHTML=xmlhttp.responseText;
        }
    }
  }
xmlhttp.open("GET",urls,true);
xmlhttp.send();
}
</script>
<script>  
function validate(){  
	
	if(document.getElementById("node").value=="")
   	{
   		alert("Node name should not be blank");
   		document.getElementById("node").focus();
   		return false;
   	}
	
	
	if(document.getElementById("password").value=="")
   	{
   		alert("password should not be blank");
   		document.getElementById("password").focus();
   		return false;
   	}
	
	if(document.getElementById("cpassword").value=="")
   	{
   		alert("Confirm password should not be blank");
   		document.getElementById("cpassword").focus();
   		return false;
   	}
	
	
	
  
}  
</script>
</head>
<body>
<%
if(request.getParameter("incorrect")!=null)
{
	out.println("<script>alert('Confirm Password does not match.')</script>");	
}
%>
<div id="tooplate_wrapper">
	<div id="tooplate_header">
        <div id="site_title"> <%@ include file="title.jsp" %></div>
    </div> <!-- end of forever header -->
    
    <div id="tooplate_menu">
        <%@ include file="menu.jsp" %>  	
    </div> <!-- end of tooplate_menu -->
    
    <div id="tooplate_main">
       	<div id="tooplate_content">
           		 
                
                <div class="post_box">
               
					
					
					
					
                    <div class="post_box_right">
                        <h2>User Registration</h2>
                        
                        <div id="contact_form">
     
      <form action="register" method="post" id="myform" name="myform" onsubmit="return validate()">
<table cellpadding="5" cellspacing="5">
<tr>
<td>Node Name</td>
<td><input type="text" name="node" id="node" placeholder="Node Name" class="required input_field" onkeyup="loadXMLDoc()"></td>
<td style="font-size: 120%"><span id="err"> </span></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password" id="password" placeholder="Password" class="required input_field"></td>
</tr>
<tr>
<td>Confirm Password</td>
<td><input type="password" name="cpassword" id="cpassword" placeholder="Confirm Password" class="required input_field"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Register" id="mySubmit" class="submit_btn float_l">
<input type="reset" value="Reset"  class="submit_btn float_l"></td>
</tr>
</table>
</form>
        </center> 
                            </div>
  
                    
					
                    <div class="cleaner"></div>
				</div>
                
                
                
                
                
                <!-- <div class="post_box post_box_last">
                	<div class="date_box">
                    	<div class="date">16<span>OCT 2048</span></div>
                        <div class="post_comment">174 comments</div>
                    </div>
					
                    <div class="post_box_right">
                        <h2>Web Design Trends </h2>
                        <div class="post_meta"><a href="#">Web Design</a> \ <a href="#">Templates</a></div>
                		<img src="images/tooplate_image_02.jpg" alt="Image 02" />
                		<p>Vestibulum turpis tellus, ornare accumsan viverra et, varius at dui. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Cras ut ipsum enim, quis aliquam odio. Vivamus cursus vestibulum sodales. Nulla facilisi. Proin at neque in tellus malesuada mattis.</p>
                         <a href="blog_post.html" class="more float_r">Continue Reading</a>
                    </div>
					
                    <div class="cleaner"></div>
				</div> -->
                
            <div class="cleaner"></div>
        </div>
        
       
        
        <div class="cleaner"></div>
	</div> <!-- end of main -->
    
     <div id="tooplate_footer_wrapper">
        <div id="tooplate_footer">
            
            <!-- <div class="col_w280">
                <h5>Pages</h5>
                <ul class="tooplate_list">
                    <li><a href="index.jsp">Etiam commodo</a></li>
                    <li><a href="index.jsp">Praesent adipiscing</a></li>
                    <li><a href="index.jsp">Duis sed justo</a></li>
                    <li><a href="index.jsp">Mauris vulputate</a></li>
                    <li><a href="index.jsp">Mauris dignissim</a></li>
                    <li><a href="index.jsp">In adipiscing purus</a></li>
                </ul>
            </div>
             -->
            <!-- <div class="col_w280">
                <h5>Partners</h5>
                <ul class="tooplate_list">
                    <li><a href="index.jsp">Aenean ac tellus nec</a></li>
                    <li><a href="index.jsp">Maecenas vestibulum</a></li>
                    <li><a href="index.jsp">Ut eget tellus eget</a></li>
                    <li><a href="index.jsp">Curabitur ut lectus</a></li>
                    <li><a href="index.jsp">Vivamus vel augue vel</a></li>
                    <li><a href="index.jsp">Praesent varius tempor</a></li>
                </ul>
            </div> -->
            
            <!-- <div class="col_w280 last_col">
                <h5>About Us</h5>
                <p>Aliquam venenatis nisl a lacus facilisis accumsan. Ut id tellus a velit adipiscing condimentum ornare nec lectus. Nam ut dui sit amet metus sagittis bibendum quis in odio. Quisque sit amet erat a lorem condimentum placerat. Duis dignissim, justo vel consequat vulputate, neque nibh gravida nisi, et posuere mauris turpis dapibus quam.</p>
            </div> -->
        
            <div class="cleaner"></div>
        </div>
        </div>
        <div id="tooplate_copyright">
		
		 <%@include file="footer.jsp" %>
        </div>
	</div>
</div> 

</body>
</html>