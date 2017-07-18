import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/Login")

public class Login extends HttpServlet {
 
    
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        try{

         	 //loading drivers for mysql
                  Class.forName("com.mysql.jdbc.Driver");

          	 //creating connection with the database 
                  Connection con=DriverManager.getConnection
                                 ("jdbc:mysql://localhost:3306/webappdb","root","apswpa");
                  PreparedStatement ps =con.prepareStatement
                                      ("SELECT * FROM user WHERE username=? and password=?");
                  ps.setString(1, user);
                  ps.setString(2, pass) ;
                  ResultSet rs =ps.executeQuery();
                  HttpSession session = null;
                  
                  
                  if(rs.next()) {
           	  
                	String username = rs.getString("username"); 
                	String name = rs.getString("name");   
                   	String surname = rs.getString("surname");  
                   	String birth = rs.getString("birth");
                   	String email = rs.getString("email");
                   	String password = rs.getString("password");
                   	String avatar = rs.getString("avatar");
                   	
                   	session=request.getSession();
                   	
                   
                   session.setAttribute("username", username);	
                   session.setAttribute("name", name);
                   session.setAttribute("surname", surname);
                   session.setAttribute("email",email);
                   session.setAttribute("birth", birth);
                   session.setAttribute("password", password);
                   session.setAttribute("avatar", avatar);
                   
                   response.sendRedirect("showNoticeBoard");
                   
                   }else
                   {
                       RequestDispatcher dsp = request.getRequestDispatcher("loginInvalid.html");
                       
                       dsp.include(request, response);
                    }
                   
                   
               }catch(Exception e)
               {
                   e.printStackTrace();
               }
                                   
               out.close();  }

       }