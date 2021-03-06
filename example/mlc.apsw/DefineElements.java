

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
@WebServlet("/DefineElements")
public class DefineElements extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DefineElements() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        String lat = request.getParameter("lat");
        String lon = request.getParameter("lng");
        HttpSession session=request.getSession(false);  
        if(session!=null){  
        String id=(String)session.getAttribute("id");
        try{
       
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/esempio","root","01072014");

        PreparedStatement ps=con.prepareStatement
        		("INSERT INTO preferiti (lat,lon,nick) VALUES (?,?,?)");
        
        ps.setString(1, lat);
        ps.setString(2, lon) ;
        ps.setString(3, id);

        int i=ps.executeUpdate();
        
        
        if(i>0)
        {
        	out.println("Place added successfully!");
        	response.sendRedirect("index2.jsp");
        }
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    	
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        out.close(); 
        }
}
}