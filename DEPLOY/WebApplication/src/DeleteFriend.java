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
 * Servlet implementation class FriendsManager
 */
@WebServlet("/DeleteFriend")
public class DeleteFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //request.getRequestDispatcher("friend_list.jsp").include(request, response);  
        
        
        String friend = request.getParameter("friend");
        HttpSession session=request.getSession(false);  
        if(session!=null){  
        String user=(String)session.getAttribute("username");  
        
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/webappdb","root","apswpa");

        PreparedStatement ps=con.prepareStatement
        		("Delete FROM  friendship where (friend1=? AND friend2=?) OR (friend1=? AND friend2=?)");
        		
        ps.setString(1, user);
        ps.setString(2, friend);
        ps.setString(3, friend);
        ps.setString(4, user);
        int i=ps.executeUpdate();
        
        if(i>0)
        { 
        	RequestDispatcher dsp=request.getRequestDispatcher("FriendList");
            dsp.forward(request,response);        }
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        out.close(); 
        }
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
