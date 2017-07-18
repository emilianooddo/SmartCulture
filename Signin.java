

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
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
        
        String id = request.getParameter("email");
        String password = request.getParameter("psw");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        Connection  con=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/esempio","root","01072014");

        PreparedStatement ps1=con.prepareStatement
                ("SELECT id FROM anagrafica where id=?");
        ps1.setString(1, id);
        ResultSet rs =ps1.executeQuery();
        if(!rs.next()){
   PreparedStatement ps=con.prepareStatement
             ("INSERT INTO anagrafica (password,id,nome,cognome) VALUES (?,?,?,?)");

   ps.setString(1,password);
   ps.setString(2, id);
   ps.setString(3,nome);
   ps.setString(4, cognome);
  
   int i=ps.executeUpdate();
   
     if(i>0)
     {
       out.println("You are sucessfully registered");
       response.sendRedirect("index.html");
     }
   
   }
        else
        	out.println("Utente già esistente!");
        	//response.sendRedirect("SimpleSignin.html");
        	}
   catch(Exception se)
   {
	   
       se.printStackTrace();
   }
        
 }
	}   



