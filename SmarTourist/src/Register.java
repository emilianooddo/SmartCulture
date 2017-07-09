import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
	
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String birth = request.getParameter("birth");
        String gender = request.getParameter("gender");
        try{
        
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	//creating connection with the database 
          Connection  con=DriverManager.getConnection
                     ("jdbc:mysql://localhost:3306/webappdb","root","root");
        
        PreparedStatement ps=con.prepareStatement
                  ("insert into user values(NULL,?,?,?,?,?,?,NULL,NULL,NULL)");
        
        // CONTROLLARE ECCEZIONI PER EVITARE REGISTRAZIONI CON STESSA EMAIL
        
        
        ps.setString(1, name);
        ps.setString(2, surname);
        ps.setString(3, email);
        ps.setString(4, gender);
        ps.setString(5, password);
        ps.setString(6, birth);
        int i=ps.executeUpdate();
        
          if(i>0)
          {
            response.sendRedirect("loginSigned.html");
          }
        
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
	
      }

}

