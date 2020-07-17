/*******************************************************************************
 * Copyright (c) 2016  Swapnil Kumawat.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms.
 * Contributors:
 *     Webminds Technology
 *******************************************************************************/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.secure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//import org.apache.commons.codec.binary.Hex;



import com.util.DBConnectionServer;
import com.util.DbConnection;

/**
 *
 * @author Swapnil
 */
public class GlobalFunction {
	
	Connection con=null;
	
	public  GlobalFunction() throws ClassNotFoundException, SQLException
	{
     con = DbConnection.getConnection();
	}
	
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();            
    String Addeddate=dateFormat.format(date);
    
    Statement st = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;
    private boolean flag;
    
    public String getRole(int id) throws SQLException{
    	
        String data = "";
        
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from role where id="+id);
        while(rs.next()){
            
            data = rs.getString("roleName");
        
        }
        return data;
    
    }
    
    public static void copyFile(File sourceFile, File destFile) throws IOException {
    	if (!sourceFile.exists()) {
    		return;
    	}
    	if (!destFile.exists()) {
    		destFile.createNewFile();
    	}
    	FileChannel source = null;
    	FileChannel destination = null;
    	source = new FileInputStream(sourceFile).getChannel();
    	destination = new FileOutputStream(destFile).getChannel();
    	if (destination != null && source != null) {
    		destination.transferFrom(source, 0, source.size());
    	}
    	if (source != null) {
    		source.close();
    	}
    	if (destination != null) {
    		destination.close();
    	}
    }
    
    
   public String getFullName(int userid) throws SQLException{
   
       String data="";
       try{
       st = con.createStatement();
       ResultSet rs = st.executeQuery("select * from user_info where id="+userid);
       if(rs.next()){
       data = rs.getString("fname")+" "+rs.getString("lname");
       }
   }catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return data;
       
   }
 
   
  public int getLatestFileID() throws SQLException{
   
       int data=0;
       try{
       st = con.createStatement();
       ResultSet rs = st.executeQuery("select id from userfile ORDER BY id DESC LIMIT 1");
       if(rs.next()){
       data = rs.getInt("id");
       }
   }catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return data;
       
   }
  

  
  public String getLatestUserID() throws SQLException{
	   
      String data="";
      try{
      st = con.createStatement();
      ResultSet rs = st.executeQuery("select id from user ORDER BY id DESC LIMIT 1");
      if(rs.next()){
      data = rs.getString("id");
      }
  }catch (SQLException e) {
           System.out.println("Error:" + e);
       } finally {
           if (st != null) {
               st.close();
           }
           if (rs != null) {
               rs.close();
           }
       }
       return data;
      
  }
  public static void CreateDirectory(String FolderName)
  {	
	File file = new File("C:\\upload\\"+FolderName);
	if (!file.exists()) {
		if (file.mkdir()) {
			System.out.println("Directory is created!");
		} else {
			System.out.println("Failed to create directory!");
		}
	}
  }
   
      public String getUserEmail(int Userid) throws SQLException{
   
       String data="";
       try{
       st = con.createStatement();
       ResultSet rs = st.executeQuery("select email from user where id='"+Userid+"'");
       if(rs.next()){
       data = rs.getString("email");
       }
   }catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return data;
       
   }
   
   public String getRoleName(int RoleID) throws SQLException{
   System.out.println("---------RoleID------"+RoleID);
       String data="";
       try{
       st = con.createStatement();
       ResultSet rs = st.executeQuery("select roleName from role where id="+RoleID);
       if(rs.next()){
       data = rs.getString("roleName");
       }
   }catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return data;
       
   }
      
   public String getUserRole(int Userid) throws SQLException{
   
       String data="";
       int UserRoleID=0;
       try{
       st = con.createStatement();
       ResultSet rs = st.executeQuery("select UserRole from user where id="+Userid);
       if(rs.next()){
       UserRoleID = rs.getInt("UserRole");
       
       
       data = getRoleName(UserRoleID);
       }
       
   }catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return data;
       
   }
   
    public int getUserRoleID(int Userid) throws SQLException{
   
       int data=0;
       int UserRoleID=0;
       try{
       st = con.createStatement();
       ResultSet rs = st.executeQuery("select UserRole from user where id="+Userid);
       if(rs.next()){
       data = rs.getInt("UserRole");
       
       
       //data = getRoleName(UserRoleID);
       }
       
   }catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return data;
       
   }
      
  
   public String getFileName(int Fileid) throws SQLException{
   
       String data="";
       try{
       st = con.createStatement();
       ResultSet rs = st.executeQuery("select fileName from userfile where id="+Fileid);
       if(rs.next()){
       data = rs.getString("fileName");
       }
   }catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return data;
       
   }
      
   public String getFileExtention(File file){
   
       String name = file.getName();
       try{
       return name.substring(name.lastIndexOf(".") + 1);
       } catch(Exception e){
       return "";
       }
       
       
   }
   
   public boolean checkAdminLogin(String username,String password) throws SQLException{
   
       try{
       st = con.createStatement();
       ResultSet rs = st.executeQuery("select * from admin where name='"+username+"' and password='"+password+"'");
       if(rs.next()){
       return true;
       }
   }catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return false;       
   }
   
   public int checkAuthorised(int fileID,int UserRol) throws SQLException{
       int data=0;
       try{
       st = con.createStatement();
       String strss1 = Integer.valueOf(UserRol).toString();
       ResultSet rs = st.executeQuery("select * from userfile where id="+fileID);
       if(rs.next()){
           String[] Authorised = rs.getString("Authorised").split(",");
          for(int i=0;i<Authorised.length;i++){
            
              
              String strss = Authorised[i];
              if(strss.equalsIgnoreCase(strss1)){
              
                  data = Integer.parseInt(strss);
                  
               return data;
              }
              
             
              //if(data==UserRol){                  
                  
              
             // } 
              
          }         
       }
   }catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return data;       
   }


   public boolean VerifySecretCode(int id,String SecretCode) throws SQLException{
   
       try{
       st = con.createStatement();
       ResultSet rs = st.executeQuery("select * from user where id="+id+" and SecretKey='"+SecretCode+"'");
       if(rs.next()){
       return true;
       }
   }catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return false;       
   }
   
   public boolean VerifyFileSecretCode(int Fileid,String SecretCode) throws SQLException{
   
       try{
       st = con.createStatement();
       ResultSet rs = st.executeQuery("select * from userfile where id="+Fileid+" and SecretKey='"+SecretCode+"'");
       if(rs.next()){
       return true;
       }
   }catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return false;       
   }
   
   
   public void setEncryptionTime(int fid,float ExcutionTime) throws SQLException{
   
       try{
       st = con.createStatement();
       String sqlss = "INSERT INTO encryption(fileId,ExcutionTime) VALUE("+fid+","+ExcutionTime+")";
       System.out.println("enr========="+sqlss);
       st.executeUpdate(sqlss);
       
   }catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        
   }
   
   public void setDecryptionTime(int fid,float ExcutionTime) throws SQLException{
   
       try{
       st = con.createStatement();
       String sqlss = "INSERT INTO decryption(fileId,ExcutionTime) VALUE("+fid+","+ExcutionTime+")";
       System.out.println("enr========="+sqlss);
       st.executeUpdate(sqlss);
       
   }catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        
   }
   
   
   public String getSecretCode(int id) throws SQLException{
   
       String data="";
       try{
       st = con.createStatement();
       ResultSet rs = st.executeQuery("select SecretKey from user where id="+id);
       if(rs.next()){
           data = rs.getString("SecretKey");
       return data;
       }
   }catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return data;       
   }
   


public String getUserFirstname(int userid) throws SQLException{
	   
    String data="";
    try{
    st = con.createStatement();
    ResultSet rs = st.executeQuery("select * from user_info where id="+userid);
    if(rs.next()){
        data = rs.getString("fname");
    return data;
    }
}catch (SQLException e) {
         System.out.println("Error:" + e);
     } finally {
         if (st != null) {
             st.close();
         }
         if (rs != null) {
             rs.close();
         }
     }
     return data;       
} 


public void RemoveDuplicateRows(String tablename, String columnname)
{
	try {
		String sql="DELETE FROM "+tablename+" WHERE NOT EXISTS (SELECT * FROM (SELECT MIN(id) minID FROM "+tablename+" GROUP BY "+columnname+" HAVING COUNT(*) > 0 ) AS q WHERE minID=id)";
		//PreparedStatement ps=con.prepareStatement("DELETE FROM autoc WHERE NOT EXISTS (SELECT * FROM (SELECT MIN(id) minID FROM autoc GROUP BY suggestion HAVING COUNT(*) > 0 ) AS q WHERE minID=id)");
		PreparedStatement ps=con.prepareStatement(sql);
		int result=ps.executeUpdate();
		if(result>0)
		{
			System.out.println("-----------Removed Duplicate Rows----------------");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}


public void InsertAutoSeggestWords(String words)
{
	try 
	{
		PreparedStatement ps=con.prepareStatement("insert into autoc (suggestion) values(?)");
		ps.setString(1, words);
		ps.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

public String removeStopWords(String content) throws IOException 
{
	 String stop = null;
	  String[] stopWrds = { "without", "see", "unless", "due", "also",
	    "must", "might", "like", "]", "[", "}", "{", "<", ">", "?",
	    "\"", "\\", "/", ")", "(", "will", "may", "can", "much",
	    "every", "the", "in", "other", "this", "the", "many", "any",
	    "an", "or", "for", "in", "an", "an ", "is", "a", "about",
	    "above", "after", "again", "against", "all", "am", "an", "and",
	    "any", "are", "aren’t", "as", "at", "be", "because", "been",
	    "before", "being", "below", "between", "both", "but", "by",
	    "can’t", "cannot", "could", "couldn’t", "did", "didn’t", "do",
	    "does", "doesn’t", "doing", "don’t", "down", "during", "each",
	    "few", "for", "from", "further", "had", "hadn’t", "has",
	    "hasn’t", "have", "haven’t", "having", "he", "he’d", "he’ll",
	    "he’s", "her", "here", "here’s", "hers", "herself", "him",
	    "himself", "his", "how", "how’s", "i ", " i", "i’d", "i’ll","i",
	    "i’m", "i’ve", "if", "in", "into", "is", "isn’t", "it", "it’s",
	    "its", "itself", "let’s", "me", "more", "most", "mustn’t",
	    "my", "myself", "no", "nor", "not", "of", "off", "on", "once",
	    "only", "ought", "our", "ours", "ourselves", "out", "over",
	    "own", "same", "shan’t", "she", "she’d", "she’ll", "she’s",
	    "should", "shouldn’t", "so", "some", "such", "than", "that",
	    "that’s", "their", "theirs", "them", "themselves", "then",
	    "there", "there’s", "these", "they", "they’d", "they’ll",
	    "they’re", "they’ve", "this", "those", "through", "to", "too",
	    "under", "until", "up", "very", "was", "wasn’t", "we", "we’d",
	    "we’ll", "we’re", "we’ve", "were", "weren’t", "what", "what’s",
	    "when", "when’s", "where", "where’s", "which", "while", "who",
	    "who’s", "whom", "why", "why’s", "with", "won’t", "would",
	    "wouldn’t", "you", "you’d", "you’ll", "you’re", "you’ve",
	    "your", "yours", "yourself", "yourselves", "Without", "See",
	    "Unless", "Due", "Also", "Must", "Might", "Like", "Will",
	    "May", "Can", "Much", "Every", "The", "In", "Other", "This",
	    "The", "Many", "Any", "An", "Or", "For", "In", "An", "An ",
	    "Is", "A", "About", "Above", "After", "Again", "Against",
	    "All", "Am", "An", "And", "Any", "Are", "Aren’t", "As", "At",
	    "Be", "Because", "Been", "Before", "Being", "Below", "Between",
	    "Both", "But", "By", "Can’t", "Cannot", "Could", "Couldn’t",
	    "Did", "Didn’t", "Do", "Does", "Doesn’t", "Doing", "Don’t",
	    "Down", "During", "Each", "Few", "For", "From", "Further",
	    "Had", "Hadn’t", "Has", "Hasn’t", "Have", "Haven’t", "Having",
	    "He", "He’d", "He’ll", "He’s", "Her", "Here", "Here’s", "Hers",
	    "Herself", "Him", "Himself", "His", "How", "How’s", "I ", " I",
	    "I’d", "I’ll", "I’m", "I’ve", "If", "In", "Into", "Is",
	    "Isn’t", "It", "It’s", "Its", "Itself", "Let’s", "Me", "More",
	    "Most", "Mustn’t", "My", "Myself", "No", "Nor", "Not", "Of",
	    "Off", "On", "Once", "Only", "Ought", "Our", "Ours",
	    "Ourselves", "Out", "Over", "Own", "Same", "Shan’t", "She",
	    "She’d", "She’ll", "She’s", "Should", "Shouldn’t", "So",
	    "Some", "Such", "Than", "That", "That’s", "Their", "Theirs",
	    "Them", "Themselves", "Then", "There", "There’s", "These",
	    "They", "They’d", "They’ll", "They’re", "They’ve", "This",
	    "Those", "Through", "To", "Too", "Under", "Until", "Up",
	    "Very", "Was", "Wasn’t", "We", "We’d", "We’ll", "We’re",
	    "We’ve", "Were", "Weren’t", "What", "What’s", "When", "When’s",
	    "Where", "Where’s", "Which", "While", "Who", "Who’s", "Whom",
	    "Why", "Why’s", "With", "Won’t", "Would", "Wouldn’t", "You",
	    "You’d", "You’ll", "You’re", "You've", "Your", "Yours",
	    "Yourself", "Yourselves", "specifically", "designed",
	    "implementation", "dependencies", "possible", "intended",
	    "let", "application", "developers", "write", "once", "run",
	    "anywhere", "meaning", "compiled", "code", "run", "platforms",
	    "support", "need", "recompilation", "applications",
	    "typically", "compiled", "run", "regardless", "one", "popular",
	    "use", "particularly", "client-server", "reported",
	    "originally", "developed", "which", "since", "acquired",
	    "corporation", "released", "component", "platform", "derives",
	    "syntax", "fewer", "facilities", "either", "them", "original",
	    "reference", "implementation", "libraries", "originally",
	    "proprietary", "community", "process", "typical", "special",
	    "depends", "depend", "implemented", "implement", "cover",
	    "out", "meet", "someone", "hang", "fell", "specific",
	    "particular", "be", "under" };

	  //String content = request.getParameter("content");
	  //PrintWriter out = response.getWriter();
	  try {
	   Scanner fip1 = new Scanner(content);
	   StringBuffer sb = new StringBuffer();
	   String All = "";
	   while (fip1.hasNext()) {
	    int flag = 1;
	    String s1 = fip1.next();
	    s1 = s1.toLowerCase();
	    for (int i = 0; i < stopWrds.length; i++) {
	     if (s1.equals(stopWrds[i].toLowerCase())) {
	      flag = 0;
	     }
	    }
	    if (flag != 0) {
	     //System.out.print(s1 + " ");
	     All = All + s1 + " ";     
	     stop=All;
	    }
	   }
	  }catch (Exception e) {
		e.printStackTrace();
	}
	return stop;
	
}


public String SplitFile(String filepath1) throws IOException {
    int totLine = 0;
    String line;
    
    FileReader file = new FileReader(filepath1);
    BufferedReader br = new BufferedReader(file);
    int i = 0;
    int mi = 0;
    String fb = "";
    String mb = "";
    String lb = "";
    while ((line = br.readLine()) != null) {
        if (!line.isEmpty()) {
            totLine++;
        }
    }
    mi = totLine / 4;
    //System.out.println("Size of mi = " + mi);
		
	  
	  
	  BufferedReader br1 = new BufferedReader(new FileReader(filepath1));
    while ((line = br1.readLine()) != null) {
        if (!line.isEmpty()) {
            if (totLine >= 4) {
                if (mi >= i) {
                    fb = fb + line + "\n";
                    i++;
                } else if ((mi * 2) >= i) {
                    mb = mb + line + "\n";
                    i++;
                } else {
                    lb = lb + line + "\n";
                }
            }
        }
    }
    file.close();
    br.close();
    br1.close();
	
    
    return fb;
    
    
}


public int getCount(String tablename) throws SQLException{
	   
    int data=0;
    try{
    st = con.createStatement();
    ResultSet rs = st.executeQuery("select count(id) from "+tablename);
    if(rs.next()){
        data = rs.getInt("count(id)");
    return data;
    }
}catch (SQLException e) {
         System.out.println("Error:" + e);
     } finally {
         if (st != null) {
             st.close();
         }
         if (rs != null) {
             rs.close();
         }
     }
     return data;       
} 


public void generateSummary()
{
	try{
		
		String path="D:\\ranking\\summary.txt";
		String path1="E:\\Workplace_Jamming\\Ranking\\WebContent\\images\\summary.txt";
		BufferedWriter writer =new BufferedWriter(new FileWriter(path));
		BufferedWriter writer1 =new BufferedWriter(new FileWriter(path1));
		PreparedStatement ps=con.prepareStatement("select * from files where line is not null group by filename order by count1");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			String filename=rs.getString("filename");
			String line=rs.getString("line");
			
		
			//writer.write(filename);
			//writer.newLine();
			writer.write(line);
			writer.newLine();
			writer.newLine();
			
			
			//writer1.write(filename);
			//writer1.newLine();
			writer1.write(line);
			writer1.newLine();
			writer1.newLine();
			
		}
		
		
		writer.close();
		writer1.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
}


public void generateSummaryFolder()
{
	try{
		String path;
		
		//String path="D:\\ranking\\summary.txt";
		//String path1="E:\\Workplace_Jamming\\Ranking\\WebContent\\images\\summary.txt";
		BufferedWriter writer = null;
		//BufferedWriter writer1 =new BufferedWriter(new FileWriter(path1));
		
		PreparedStatement pst=con.prepareStatement("select * from topic1");
		ResultSet rst=pst.executeQuery();
		while(rst.next())
		{
			String topicname=rst.getString("name1");
			//System.out.println(topicname);
			
			 path="D:\\ranking\\"+topicname+"\\summary_"+topicname+".txt";
			 writer =new BufferedWriter(new FileWriter(path));
		
		PreparedStatement ps=con.prepareStatement("select * from files where line is not null and topic1=? group by filename order by count1");
		ps.setString(1, topicname);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			String filename=rs.getString("filename");
			String line=rs.getString("line");
			String topic1=rs.getString("topic1");
		
			
			
			//writer.write(filename);
			//writer.newLine();
			writer.write(line);
			writer.newLine();
			//writer.newLine();
			
			
			//writer1.write(filename);
			//writer1.newLine();
			
			//writer1.write(line);
			//writer1.newLine();
			//writer1.newLine();
			
		}
		writer.close();
		}
		
	
	
		//writer1.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
}

public  int search1(String text, String filePath) throws IOException {
	   
	
	int count = 0;	  
    String line;
    String text1="";
    text = text.toLowerCase();
    FileReader fr = new FileReader(filePath);
    BufferedReader br = new BufferedReader(fr);
    
  
    
    while ((line = br.readLine()) != null) {
        int fromIndex = 0;
        int index = -1;
         
        while ((index = line.toLowerCase().indexOf(text, fromIndex)) != -1) {
            count++;
           fromIndex = index + text.length();
         
        }

    }

    
    fr.close();
    br.close();
    

    return count;
}


public  int arraysearch(String text,String filePath1)
{
	System.out.println("---------------------------");
	String str = text.toLowerCase();
	String inputSearch[] = str.split(" ");
    

    int count = 0,countBuffer=0,countLine=0;
    String lineNumber = "";
    String filePath = filePath1 ;
    BufferedReader br;
    
    String line = "";
    
    
    
  int  flag=0;

    try {
        br = new BufferedReader(new FileReader(filePath));
        try {
            while((line = br.readLine()) != null)
            {
                countLine++;
              
                String[] words = line.toLowerCase().split(" ");

                for(int i=0;i<inputSearch.length;i++)
                {
                for (String word : words) {
                  if (word.equals(inputSearch[i])) 
                  {
                    count++;
                    countBuffer++;
                    //System.out.println(line);
                  
                  }
              
                }
                }
                
                if(countBuffer > 0)
                {
                    countBuffer = 0;
                    lineNumber += countLine + ",";
                }

            }
           
            br.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    } catch (FileNotFoundException e) {
        
        e.printStackTrace();
    }
	return count;


	
}

public String parseFile(String filename, String searchStr) throws ServletException, IOException 
{
	    String line = null ;
	    String sendline=null;
	    Scanner scan = new Scanner(new File(filename));
        while(scan.hasNext()){
           line = scan.nextLine().toLowerCase().toString();
             if(line.contains(searchStr.toLowerCase()))
            {
               // System.out.println(line);
            //	System.out.println("Data found at "+filename);
            	sendline=line;
            	
            	
            } 
        }
	
	return sendline;
	 
}

public int xmlSearch(String query,String path)
{
	int count=0;
	try {

		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
			
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
		NodeList nList = doc.getElementsByTagName("P");
				
		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
					
			//System.out.println("\nCurrent Element :" + nNode.getTextContent());
					
			String ss=nNode.getTextContent();
			String aa=query;
			
			//Important code
			Boolean found = Arrays.asList(ss.split(" ")).contains(aa);
			String str=nNode.getTextContent().toLowerCase();
			
			int ff=str.indexOf(aa.toLowerCase()); 
			if(ff>=0)
			{
				//System.out.println("\nCurrent Element :" + nNode.getTextContent());
				count++;
				
			}
			
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	
	return count;
	}

public int xmlArray(String query,String path)
{
	int count=0;
	try {

		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
				
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
		NodeList nList = doc.getElementsByTagName("P");
				
		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
					
			//System.out.println("\nCurrent Element :" + nNode.getTextContent());
					
			String ss=nNode.getTextContent();
			String aa=query;
			String arr[]=aa.split(" ");
			//Important code
			for(int i=0;i<arr.length;i++){
			Boolean found = Arrays.asList(ss.split(" ")).contains(arr[i]);
			String str=nNode.getTextContent().toLowerCase();
			
			int ff=str.indexOf(arr[i].toLowerCase()); 
			if(ff>=0)
			{
				//System.out.println("\nCurrent Element :" + nNode.getTextContent());
				//System.out.println(arr[i]);
				count++;
				
			}
		
		}}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	return count;
}


public String xmlSearchOutputline(String query,String path)
{
	int count=0;
	String str1="";
	try {

		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
			
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
		NodeList nList = doc.getElementsByTagName("P");
				
		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
					
			//System.out.println("\nCurrent Element :" + nNode.getTextContent());
					
			String ss=nNode.getTextContent();
			String aa=query;
			
			//Important code
			Boolean found = Arrays.asList(ss.split(" ")).contains(aa);
			String str=nNode.getTextContent().toLowerCase();
			
			int ff=str.indexOf(aa.toLowerCase()); 
			if(ff>=0)
			{
				//System.out.println("\nCurrent Element :" + nNode.getTextContent());
				count++;
				 str1=nNode.getTextContent();
				 break;
				
			}
			
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	
	return str1;
	}

public String xmlArrayOutputline(String query,String path)
{
	int count=0;
	String str1="";
	try {

		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
				
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
		NodeList nList = doc.getElementsByTagName("P");
				
		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
					
			//System.out.println("\nCurrent Element :" + nNode.getTextContent());
					
			String ss=nNode.getTextContent();
			String aa=query;
			String arr[]=aa.split(" ");
			//Important code
			for(int i=0;i<arr.length;i++){
			Boolean found = Arrays.asList(ss.split(" ")).contains(arr[i]);
			String str=nNode.getTextContent().toLowerCase();
			
			int ff=str.indexOf(arr[i].toLowerCase()); 
			if(ff>=0)
			{
				//System.out.println("\nCurrent Element :" + nNode.getTextContent());
				//System.out.println(arr[i]);
				count++;
				str1=nNode.getTextContent();
				break;
				
			}
		
		}}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	return str1;
}

public void DeleteFile()
{
	try{
		String path;

		
		PreparedStatement pst=con.prepareStatement("select * from topic1");
		ResultSet rst=pst.executeQuery();
		while(rst.next())
		{
			String topicname=rst.getString("name1");
			//System.out.println(topicname);
			
			 path="D:\\ranking\\"+topicname+"\\summary_"+topicname+".txt";
			 
			 
			 File file = new File(path);
	    		
	    		long size=file.length();
	    		//System.out.println(size);
	    		
	    		if(size==0)
	    		{
	    			file.delete();
	    			
	    		}
			 
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
}

public void DeleteAllFiles(String tablename)
{
	try{
		
	String sql="delete from "+tablename;
	PreparedStatement ps=con.prepareStatement(sql);
	ps.executeUpdate();
	
	String sql1="ALTER TABLE "+tablename+" AUTO_INCREMENT = 1";
	PreparedStatement ps1=con.prepareStatement(sql1);
	ps1.executeUpdate();
	
	}catch (Exception e) {
		e.printStackTrace();
	}
}

public void AllClusterHead(String chname)
{
	try {
		PreparedStatement ps=con.prepareStatement("insert into server_chlogin (chname) values(?)");
		ps.setString(1, chname);		
		ps.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

public int ClusterHeadStatus(String PcName)
{
	int result = 0;
	try {
		Connection con1=DBConnectionServer.getConnection();
		PreparedStatement ps=con1.prepareStatement("select * from server_chlogin");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			String chname=rs.getString("chname");
			
			if(chname.equals(PcName))
			{
				PreparedStatement ps1=con1.prepareStatement("update server_chlogin set status='yes' where chname=?");
				ps1.setString(1, PcName);
			 result=ps1.executeUpdate();
				
			}
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
	
}

}