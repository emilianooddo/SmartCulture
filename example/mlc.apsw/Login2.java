

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login2")
public class Login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
        PrintWriter out = response.getWriter();
       
        String user = request.getParameter("id");
        String password = request.getParameter("password");
        
        
        try{

  	 //loading drivers for mysql
           Class.forName("com.mysql.jdbc.Driver");

   	 //creating connection with the database 
           Connection con=DriverManager.getConnection
                          ("jdbc:mysql://localhost:3306/esempio","root","01072014");
           PreparedStatement ps =con.prepareStatement
                               ("SELECT * FROM anagrafica WHERE id =? and password=?");
           ps.setString(1, user);
           ps.setString(2, password) ;
           ResultSet rs =ps.executeQuery();
           HttpSession session = null;
           
           if(rs.next()) {
        	   //request.getRequestDispatcher("index2.jsp").include(request, response);  
        	   
            	String nome = rs.getString("nome");   
            	String cognome = rs.getString("cognome");  
            	String data = rs.getString("data");
            	String id = rs.getString("id");
            	String psw = rs.getString("password");
            	String foto= rs.getString("foto");
            	
            	
             session=request.getSession();  
             
            session.setAttribute("nome", nome);
            session.setAttribute("cognome", cognome);
            session.setAttribute("foto", foto);
            session.setAttribute("id", id);
            out.print("WELCOME, "+nome +" " + id); 
        	response.sendRedirect("index2.jsp");
            
            
             
             
            }else
            {
                out.println("Username or Password incorrect");
                RequestDispatcher dsp = request.getRequestDispatcher("SimpleLogin.html");
                
                dsp.include(request, response);
             }
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
                            
        out.close();  }

}
