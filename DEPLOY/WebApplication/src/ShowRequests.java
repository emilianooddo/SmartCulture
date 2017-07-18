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
 * Servlet implementation class ShowRequests
 */
@WebServlet("/ShowRequests")
public class ShowRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        List<String> myFriends = new ArrayList<String>();
        String user;
        HttpSession session=request.getSession(false);  
        
        user=(String) session.getAttribute("username");
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/webappdb","root","apswpa");

        PreparedStatement ps=con.prepareStatement
        		("SELECT * FROM request WHERE receiver=?");
        		
        ps.setString(1, user);
        
        
        ResultSet rs =ps.executeQuery();
        String sender = new String();
        while(rs.next())
        {
        	sender = rs.getString("sender");
        	myFriends.add(sender);
        	//request.setAttribute("sender",sender);
        }
        int size = myFriends.size();
        String[] friends_request = new String[size];
        friends_request = myFriends.toArray(new String[size]);
        
        session.setAttribute("friends_request",friends_request);
    	
        RequestDispatcher dsp=request.getRequestDispatcher("friend_request.jsp");
        dsp.forward(request,response);
        
            
            }catch(Exception e)
            {
                e.printStackTrace();
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