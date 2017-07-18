import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AcceptFriend
 */
@WebServlet("/AcceptFriend")
public class AcceptFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptFriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String user_1,user_2;
        user_2=(String)request.getParameter("sender");

        HttpSession session=request.getSession(false);  
        if(session!=null){  
        user_1=(String)session.getAttribute("username");
        
        
        try{
      
        	try{
        		
        	Class.forName("com.mysql.jdbc.Driver");
        	 Connection  con=DriverManager.getConnection
 	                ("jdbc:mysql://localhost:3306/webappdb","root","apswpa");
        	 
            PreparedStatement ps2=con.prepareStatement
            		("INSERT INTO friendship (friend1, friend2) VALUES (?,?)");
            PreparedStatement ps3=con.prepareStatement
            		("DELETE FROM request WHERE (sender=? AND receiver=?) OR (sender=? AND receiver=?)");
            
            ps2.setString(1, user_1);
            ps2.setString(2, user_2);
            ps3.setString(1, user_1);
            ps3.setString(2, user_2);
            ps3.setString(3, user_2);
            ps3.setString(4, user_1);

            
            int i=ps2.executeUpdate();
            int j=ps3.executeUpdate();
            
            if(i>0 && j>0)
            {
            	RequestDispatcher dsp=request.getRequestDispatcher("ShowRequests");
                dsp.forward(request,response);            }
            
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        	
        	
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }
        out.close(); 

		 
	        }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}