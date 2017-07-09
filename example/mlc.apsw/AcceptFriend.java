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

import com.mysql.cj.api.jdbc.Statement;

/**
 * Servlet implementation class FriendsManager
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
	        
	        HttpSession session=request.getSession(false);  
	        if(session!=null){  
	        user_1=(String)session.getAttribute("id");
	        user_2=(String)session.getAttribute("user_ric");
	        try{
	        /*Class.forName("com.mysql.jdbc.Driver");
	        Connection  con=DriverManager.getConnection
	                ("jdbc:mysql://localhost:3306/esempio","root","01072014");

	        PreparedStatement ps=con.prepareStatement
	        		("SELECT * FROM richieste WHERE user_ricev=?");
	        		
	        ps.setString(1, user);
	        
	        
	        ResultSet rs =ps.executeQuery();*/
	        
	       
	        	try{
	        	//int n = rs.getInt("id");   
	        	//String user_1 = rs.getString("user_ricev");  
	        	Class.forName("com.mysql.jdbc.Driver");
	        	 Connection  con=DriverManager.getConnection
	 	                ("jdbc:mysql://localhost:3306/esempio","root","01072014");
	            Connection  con2=DriverManager.getConnection
	                    ("jdbc:mysql://localhost:3306/esempio","root","01072014");

	            PreparedStatement ps2=con.prepareStatement
	            		("INSERT INTO amicizie (user_1,user_2) VALUES (?,?)");
	            PreparedStatement ps3=con2.prepareStatement
	            		("DELETE FROM richieste WHERE (user_ric=? AND user_ricev=?) OR (user_ric=? AND user_ricev=?)");
	            
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
	            	out.println("Friend added successfully!" +" <a id=\"add\" href="+"ShowRequets"+">back</a>"+"</br>");
	            }
	            
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
