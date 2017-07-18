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
@WebServlet("/ModifyProfile")
public class ModifyProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyProfile() {
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
	        
	        String name = request.getParameter("name");
	        String surname = request.getParameter("surname");
	        String avatar = request.getParameter("avatar");
	        
	        
	        
	        if(session!=null){  
	            String user=(String)session.getAttribute("username");
	            String nome=(String)session.getAttribute("name");
	            String cognome=(String)session.getAttribute("surname");
	            String foto=(String)session.getAttribute("avatar");
	            
	            if(name.equals(""))
	            	name=nome;
	            if(surname.equals(""))
	            	surname=cognome;
	            if(avatar.equals(""))
	            	avatar=foto;
	            
	        try{
	        	Class.forName("com.mysql.jdbc.Driver");
	        	Connection  con=DriverManager.getConnection
	                ("jdbc:mysql://localhost:3306/webappdb","root","apswpa");

	        	PreparedStatement ps=con.prepareStatement
	        		("UPDATE user SET name =?, surname =?, avatar=?  WHERE username =?");


	        	ps.setString(1, name);
	        	ps.setString(2, surname);
	        	ps.setString(3, avatar);
	        	ps.setString(4, user);
	        	int i=ps.executeUpdate();
	   
	        	if(i>0)	{
	        		out.println("Profile information updated");
	        		response.sendRedirect("profile.jsp");
	        		session.setAttribute("name", name);
	        		session.setAttribute("surname", surname);
	        		session.setAttribute("avatar", avatar);
	        	}
	   
	        }
	        catch(Exception se)	{
		   
	        	se.printStackTrace();
	        }

	        }
	 }  
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
}

}