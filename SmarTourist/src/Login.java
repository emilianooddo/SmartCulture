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
        
        String email = request.getParameter("e-mail");
        String password = request.getParameter("pass");
        
        try{

         	 //loading drivers for mysql
                  Class.forName("com.mysql.jdbc.Driver");

          	 //creating connection with the database 
                  Connection con=DriverManager.getConnection
                                 ("jdbc:mysql://localhost:3306/webappdb","root","root");
                  PreparedStatement ps =con.prepareStatement
                                      ("SELECT * FROM user WHERE email=? and password=?");
                  ps.setString(1, email);
                  ps.setString(2, password) ;
                  ResultSet rs =ps.executeQuery();
                  HttpSession session = null;
                  
                  
                  if(rs.next()) {
                	//request.getRequestDispatcher("homepage.jsp").include(request, response);  
                	  
                   	String nome = rs.getString("name");   
                   	String cognome = rs.getString("surname");  
                   	String data = rs.getString("birth");
                   	String mail = rs.getString("email");
                   	String psw = rs.getString("password");
                   	String foto= rs.getString("avatar");
                   	
                   	session=request.getSession();
                   	
                   
                   session.setAttribute("name", nome);
                   session.setAttribute("surname", cognome);
                   session.setAttribute("email",mail);
                   session.setAttribute("birth", data);
                   session.setAttribute("avatar", foto);
                   
                   response.sendRedirect("homepage.jsp");
                   
                   }else
                   {
                       //out.println("<h2 color:'white'>Username or Password incorrect</h2>");
                	   //sballa il layout, sistemare
                       RequestDispatcher dsp = request.getRequestDispatcher("index.html");
                       
                       dsp.include(request, response);
                    }
                   
                   
               }catch(Exception e)
               {
                   e.printStackTrace();
               }
                                   
               out.close();  }

       }