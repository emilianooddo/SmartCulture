import java.sql.*;

import javax.servlet.annotation.WebServlet;


@WebServlet("/Validate")

public class Validate
 {
     public static boolean checkUser(String email,String password) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/webappdb","root","root");
         PreparedStatement ps =con.prepareStatement
                             ("select * from user where email=? and password=?");
         ps.setString(1, email);
         ps.setString(2, password);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}