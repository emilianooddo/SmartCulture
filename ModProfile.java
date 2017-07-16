

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.util.Enumeration;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/ModProfile")
public class ModProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        HttpSession session=request.getSession(false);  
	        
	        String nome = request.getParameter("nome");
	        String cognome = request.getParameter("cognome");
	        String foto = request.getParameter("foto");
	        if(session!=null){  
	            String user=(String)session.getAttribute("id");  
	        try{
	        	Class.forName("com.mysql.jdbc.Driver");
	        Connection  con=DriverManager.getConnection
	                ("jdbc:mysql://localhost:3306/esempio","root","01072014");

	   PreparedStatement ps=con.prepareStatement
	             ("UPDATE anagrafica SET nome =?, cognome =?, foto=?  WHERE id =?");


	   ps.setString(1,nome);
	   ps.setString(2, cognome);
	   ps.setString(3, foto);
	   ps.setString(4, user);
	   int i=ps.executeUpdate();
	   
	     if(i>0)
	     {
	       out.println("Profile information updated");
	       response.sendRedirect("index2.jsp");
	       session.setAttribute("nome", nome);
           session.setAttribute("cognome", cognome);
           session.setAttribute("foto", foto);
	     }
	   
	   }
	   catch(Exception se)
	   {
		   
	       se.printStackTrace();
	   }

	 }
	    }  
		// TODO Auto-generated method stub
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
}

}
