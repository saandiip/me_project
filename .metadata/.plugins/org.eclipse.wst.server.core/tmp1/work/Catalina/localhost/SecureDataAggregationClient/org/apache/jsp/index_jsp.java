/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2020-07-17 07:07:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.Format;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import com.secure.LoadForm;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/title1.jsp", Long.valueOf(1594897526529L));
    _jspx_dependants.put("/slideimg.jsp", Long.valueOf(1594897526738L));
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1594897526134L));
    _jspx_dependants.put("/menu.jsp", Long.valueOf(1594897526426L));
    _jspx_dependants.put("/title.jsp", Long.valueOf(1594897526705L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.text.Format");
    _jspx_imports_classes.add("java.text.DateFormatSymbols");
    _jspx_imports_classes.add("java.util.Calendar");
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("com.secure.LoadForm");
    _jspx_imports_classes.add("java.text.DateFormat");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>");
      out.write("Secure Data Aggregation");
      out.write("</title>\r\n");
      out.write("<meta name=\"keywords\" content=\"\" />\r\n");
      out.write("<meta name=\"description\" content=\"\" />\r\n");
      out.write("<!--\r\n");
      out.write("Template 2030 Elegant\r\n");
      out.write("http://www.tooplate.com/view/2030-elegant\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"tooplate_style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/nivo-slider.css\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"js/jquery.nivo.slider.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(window).load(function() {\r\n");
      out.write("\t$('#slider').nivoSlider({\r\n");
      out.write("\t\teffect:'random',\r\n");
      out.write("\t\tslices:15,\r\n");
      out.write("\t\tanimSpeed:500,\r\n");
      out.write("\t\tpauseTime:3000,\r\n");
      out.write("\t\tstartSlide:0, //Set starting Slide (0 index)\r\n");
      out.write("\t\tdirectionNav:false, \r\n");
      out.write("\t\tdirectionNavHide:false, //Only show on hover\r\n");
      out.write("\t\tcontrolNav:false, //1,2,3...\r\n");
      out.write("\t\tcontrolNavThumbs:false, //Use thumbnails for Control Nav\r\n");
      out.write("\t\tpauseOnHover:true, //Stop animation while hovering\r\n");
      out.write("\t\tmanualAdvance:false, //Force manual transitions\r\n");
      out.write("\t\tcaptionOpacity:0.8, //Universal caption opacity\r\n");
      out.write("\t\tbeforeChange: function(){},\r\n");
      out.write("\t\tafterChange: function(){},\r\n");
      out.write("\t\tslideshowEnd: function(){} //Triggers after all slides have been shown\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

if(request.getParameter("success")!=null)
{
	out.println("<script>alert('Register Successfully.')</script>");	
}
if(request.getParameter("failed")!=null)
{
	out.println("<script>alert('Username or Password Incorrect.')</script>");	
}

      out.write("\r\n");
      out.write("<div id=\"tooplate_wrapper\">\r\n");
      out.write("\t<div id=\"tooplate_header\">\r\n");
      out.write("\t        <div id=\"site_title\">\r\n");
      out.write("\t        ");
      out.write("<i><h1 style=\"color:white; font-family:Impavt,charcoal,sans-serif; font-size: 40px; font-weight:bold;\">Secure Data Aggregation Technique</h1></i>");
      out.write("\r\n");
      out.write("\t        </div>\r\n");
      out.write("    </div> <!-- end of forever header -->\r\n");
      out.write("    \r\n");
      out.write("    <div id=\"tooplate_menu\">\r\n");
      out.write("        ");
      out.write(' ');

 if(session.getAttribute("username")!=null)
 {
	 
      out.write("\r\n");
      out.write("\t <ul>\r\n");
      out.write("            <li><a href=\"home.jsp\" class=\"current\">Home</a></li>\r\n");
      out.write("            <!-- <li><a href=\"\">Capture</a></li> -->\r\n");
      out.write("            <li><a href=\"send.jsp\">Send Data</a></li>\r\n");
      out.write("            <li><a href=\"view.jsp\">View Data</a></li>\r\n");
      out.write("            <li><a href=\"logout\">Logout</a></li>\r\n");
      out.write("            \r\n");
      out.write("   </ul>  \r\n");
      out.write("\t \r\n");
      out.write("\t ");
}else if(session.getAttribute("chusername")!=null)
	 {
		 
      out.write("\r\n");
      out.write("\t\t <ul>\r\n");
      out.write("\t            <li><a href=\"chhome.jsp\" class=\"current\">Home</a></li>\r\n");
      out.write("\t            <li><a href=\"viewnode.jsp\">View Nodes</a></li>\r\n");
      out.write("\t            \r\n");
      out.write("\t            <li><a href=\"checkdataaggregation\">Aggregate Data</a></li>\r\n");
      out.write("\t            <li><a href=\"notification.jsp\">Notification</a></li>\r\n");
      out.write("\t            <li><a href=\"logout\">Logout</a></li>\r\n");
      out.write("\t            \r\n");
      out.write("\t   </ul>  \r\n");
      out.write("\t    ");

 }else if(session.getAttribute("username")==null){
 
      out.write("\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" <ul>\r\n");
      out.write("            <li><a href=\"index.jsp\" class=\"current\">Home</a></li>\r\n");
      out.write("            <li><a href=\"register.jsp\">Register</a></li>\r\n");
      out.write("            <li><a href=\"clusterhead.jsp\">Cluster Head</a></li>\r\n");
      out.write("            <li><a href=\"about.jsp\">About us</a></li>\r\n");
      out.write("            \r\n");
      out.write("   </ul> \r\n");
      out.write("\t\t ");

	 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \t\r\n");
      out.write("    </div> <!-- end of tooplate_menu -->\r\n");
      out.write("    \r\n");
      out.write("    <div id=\"tooplate_main\">\r\n");
      out.write("       \t<div id=\"tooplate_content\">\r\n");
      out.write("           \t\t<div id=\"homepage_slider\">\r\n");
      out.write("                    <div id=\"slider\">\r\n");
      out.write("                       ");
      out.write("                        <a href=\"#\"><img src=\"images/slideshow/01.jpg\" alt=\"Slide 01\"  /></a>\r\n");
      out.write("                        <a href=\"#\"><img src=\"images/slideshow/02.jpg\" alt=\"Slide 02\"  /></a>\r\n");
      out.write("                        <a href=\"#\"><img src=\"images/slideshow/03.jpg\" alt=\"Slide 03\"  /></a>\r\n");
      out.write("                        <a href=\"#\"><img src=\"images/slideshow/04.jpg\" alt=\"Slide 04\"  /></a>\r\n");
      out.write("                        <a href=\"#\"><img src=\"images/slideshow/05.jpg\" alt=\"Slide 05\"  /></a>\r\n");
      out.write("                  ");
      out.write("\r\n");
      out.write("                         </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"post_box\">\r\n");
      out.write("                \t<div class=\"date_box\">\r\n");
      out.write("                \t");

                	DateFormat dd=new SimpleDateFormat("dd");
                	Date date=new Date();
                	
                	Calendar cal =Calendar.getInstance();
                	DateFormat dd2=new SimpleDateFormat("yyyy");
             		
             		
             		Format formater=new SimpleDateFormat("EEEE");
             		/* System.out.println(formater.format(new Date())); */
                	 
                	 
      out.write("\r\n");
      out.write("                    \t<div class=\"date\">");
      out.print(dd.format(date) );
      out.write("<span>");
      out.print(new SimpleDateFormat("MMMM").format(cal.getTime()));
      out.write(' ');
      out.print(dd2.format(date) );
      out.write("</span></div>\r\n");
      out.write("                        <div class=\"post_comment\"> ");
      out.print(formater.format(new Date()) );
      out.write("</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("                    <div class=\"post_box_right\">\r\n");
      out.write("                        <h2>User Login</h2>\r\n");
      out.write("                      <!--   <div class=\"post_meta\"><a href=\"#\">Graphics</a> \\ <a href=\"#\">Illustrations</a></div>\r\n");
      out.write("                \t\t<img src=\"images/tooplate_image_01.jpg\" alt=\"Image 01\" />\r\n");
      out.write("                        <p>Elegant is a <a rel=\"nofollow\" href=\"http://www.tooplate.com\" target=\"_parent\">free website template</a> for everyone. Credits go to <a rel=\"nofollow\" href=\"http://www.photovaco.com\" target=\"_blank\">PhotoVaco</a> for photos and <a rel=\"nofollow\" href=\"http://nivo.dev7studios.com\" target=\"_blank\">Dev7Studios</a> for Nivo Slider. Integer ultrices enim non ipsum pulvinar, sed tincidunt ipsum lacinia.</p>\r\n");
      out.write("                         <a href=\"blog_post.html\" class=\"more float_r\">Continue Reading</a>\r\n");
      out.write("                    </div> -->\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                    <div id=\"contact_form\">\r\n");
      out.write("     \r\n");
      out.write("             <form action=\"login\" method=\"post\">\t\r\n");
      out.write("\t\t\t<table cellpadding=\"10\" cellspacing=\"10\">\r\n");
      out.write("\t\t\t<tr><td>Username:</td><td><input type=\"text\" name=\"username\" required class=\"required input_field\"  placeholder=\"Enter Username\" /></td></tr>\r\n");
      out.write("            <tr><td>password:</td><td><input type=\"password\" name=\"password\" required class=\"required input_field\" placeholder=\"Enter Password\"/></td></tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("            <tr>\r\n");
      out.write("            \r\n");
      out.write("            <td><input type=\"submit\" value=\"Submit\" class=\"submit_btn float_l\" /></td>\r\n");
      out.write("            <td ><a href=\"register.jsp\"><img src=\"images/adduser.png\" width=\"50\" height=\"50\" title=\"Register\" alt=\"\"></img></a></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("  </table><br/>\r\n");
      out.write(" \r\n");
      out.write("  </form>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("                    \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("                    <div class=\"cleaner\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                <!-- <div class=\"post_box post_box_last\">\r\n");
      out.write("                \t<div class=\"date_box\">\r\n");
      out.write("                    \t<div class=\"date\">16<span>OCT 2048</span></div>\r\n");
      out.write("                        <div class=\"post_comment\">174 comments</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("                    <div class=\"post_box_right\">\r\n");
      out.write("                        <h2>Web Design Trends </h2>\r\n");
      out.write("                        <div class=\"post_meta\"><a href=\"#\">Web Design</a> \\ <a href=\"#\">Templates</a></div>\r\n");
      out.write("                \t\t<img src=\"images/tooplate_image_02.jpg\" alt=\"Image 02\" />\r\n");
      out.write("                \t\t<p>Vestibulum turpis tellus, ornare accumsan viverra et, varius at dui. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Cras ut ipsum enim, quis aliquam odio. Vivamus cursus vestibulum sodales. Nulla facilisi. Proin at neque in tellus malesuada mattis.</p>\r\n");
      out.write("                         <a href=\"blog_post.html\" class=\"more float_r\">Continue Reading</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("                    <div class=\"cleaner\"></div>\r\n");
      out.write("\t\t\t\t</div> -->\r\n");
      out.write("                \r\n");
      out.write("            <div class=\"cleaner\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("       \r\n");
      out.write("        \r\n");
      out.write("        <div class=\"cleaner\"></div>\r\n");
      out.write("\t</div> <!-- end of main -->\r\n");
      out.write("    \r\n");
      out.write("     <div id=\"tooplate_footer_wrapper\">\r\n");
      out.write("        <div id=\"tooplate_footer\">\r\n");
      out.write("            \r\n");
      out.write("            <!-- <div class=\"col_w280\">\r\n");
      out.write("                <h5>Pages</h5>\r\n");
      out.write("                <ul class=\"tooplate_list\">\r\n");
      out.write("                    <li><a href=\"index.jsp\">Etiam commodo</a></li>\r\n");
      out.write("                    <li><a href=\"index.jsp\">Praesent adipiscing</a></li>\r\n");
      out.write("                    <li><a href=\"index.jsp\">Duis sed justo</a></li>\r\n");
      out.write("                    <li><a href=\"index.jsp\">Mauris vulputate</a></li>\r\n");
      out.write("                    <li><a href=\"index.jsp\">Mauris dignissim</a></li>\r\n");
      out.write("                    <li><a href=\"index.jsp\">In adipiscing purus</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("             -->\r\n");
      out.write("            <!-- <div class=\"col_w280\">\r\n");
      out.write("                <h5>Partners</h5>\r\n");
      out.write("                <ul class=\"tooplate_list\">\r\n");
      out.write("                    <li><a href=\"index.jsp\">Aenean ac tellus nec</a></li>\r\n");
      out.write("                    <li><a href=\"index.jsp\">Maecenas vestibulum</a></li>\r\n");
      out.write("                    <li><a href=\"index.jsp\">Ut eget tellus eget</a></li>\r\n");
      out.write("                    <li><a href=\"index.jsp\">Curabitur ut lectus</a></li>\r\n");
      out.write("                    <li><a href=\"index.jsp\">Vivamus vel augue vel</a></li>\r\n");
      out.write("                    <li><a href=\"index.jsp\">Praesent varius tempor</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div> -->\r\n");
      out.write("            \r\n");
      out.write("            <!-- <div class=\"col_w280 last_col\">\r\n");
      out.write("                <h5>About Us</h5>\r\n");
      out.write("                <p>Aliquam venenatis nisl a lacus facilisis accumsan. Ut id tellus a velit adipiscing condimentum ornare nec lectus. Nam ut dui sit amet metus sagittis bibendum quis in odio. Quisque sit amet erat a lorem condimentum placerat. Duis dignissim, justo vel consequat vulputate, neque nibh gravida nisi, et posuere mauris turpis dapibus quam.</p>\r\n");
      out.write("            </div> -->\r\n");
      out.write("        \r\n");
      out.write("            <div class=\"cleaner\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div id=\"tooplate_copyright\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("            ");
      out.write("Copyright ©  Web Minds Technology\r\n");
      out.write("\r\n");
      out.write("\r\n");
new LoadForm();
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("        </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div> \r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
