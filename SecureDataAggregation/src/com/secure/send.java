package com.secure;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.util.DbConnection;


public class send extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final String UPLOAD_DIRECTORY = "D:\\DataAggregation\\nodefiles\\";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		
		
	       if(ServletFileUpload.isMultipartContent(request)){
	           try {
	               List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	               DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	               Date date = new Date();            
	               String Addeddate=dateFormat.format(date);
	               String username = (String)session.getAttribute("username");
	              
	              // GlobalFunction GF=new GlobalFunction();
	               String FileName = "";
	               
	               String FileExtention = "";
	               long FileSize = 0;
	               
	              String Weightage = "";
	               String keyword="";
	               String name = null;
	               
	               for(FileItem item : multiparts){
	            	   if(!item.isFormField())
	                   {
	                	  // System.out.println("2");
	                        name = new File(item.getName()).getName();
	                     
	                       item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
	                       FileName = item.getName();
	                       FileExtention = item.getContentType();
	                       FileName = item.getName();
	                       FileSize = item.getSize();
	                       
	                      // System.out.println("-----ddddd-----------"+FileName);
	                       
	                   }
	                   else if (item.getFieldName().equals("Weightage")) {
	                	   Weightage  = item.getString();
	                	    //System.out.println("ssssss"+url);
	                	    
	                	         }
	            	   
	                   else if (item.getFieldName().equals("sub")) {
	                	    keyword = item.getString();
	                	         }
	            	   
	               }
	          
	             
	       		
	               String path=UPLOAD_DIRECTORY+FileName;
					FileReader f = new FileReader(path);

			        
			        BufferedReader reader = new BufferedReader(f);
			        String text = "";
			        String line = reader.readLine();
			        while (line != null) {
			            text += line;
			            line = reader.readLine();
			          
			        }
			        reader.close();
			        
			        
			        String file=text;
			        
			        
			        MessageDigest md = MessageDigest.getInstance("MD5");
          			String digest = getDigest(new FileInputStream(path), md, 2048);
          			//System.out.println("============ "+digest);
	              
	               Connection con=DbConnection.getConnection();
	               PreparedStatement ps=con.prepareStatement("insert into files(nodename,filename,file,weightage,digest) values(?,?,?,?,?)");
	               ps.setString(1, username);
	               ps.setString(2, FileName);
	               ps.setString(3, file);
	               ps.setString(4, Weightage);
	               ps.setString(5, digest);
	 
	               ps.executeUpdate();
	               
				response.sendRedirect("send.jsp?upload");
				
	       
	           } catch (Exception ex) {
	             ex.printStackTrace();
	           }          
	        
	       }else{
	           request.setAttribute("message",
	                                "Sorry this Servlet only handles file upload request");
	       }
	   
	       
	    
	   }
	
	
	public static String getDigest(InputStream is, MessageDigest md, int byteArraySize)
			throws NoSuchAlgorithmException, IOException {

		md.reset();
		byte[] bytes = new byte[byteArraySize];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			md.update(bytes, 0, numBytes);
		}
		byte[] digest = md.digest();
		String result = new String(Hex.encodeHex(digest));
		return result;
	}
	}


