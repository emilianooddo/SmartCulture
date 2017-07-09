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
@WebServlet("/ShowRequets")
public class ShowRequets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRequets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("friend_list.jsp").include(request, response); 
        PrintWriter out = response.getWriter();
        List<String> myFriends = new ArrayList<String>();
        String user,user2;
        HttpSession session=request.getSession(false);  
        
        user=(String) session.getAttribute("id");
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/esempio","root","01072014");

        PreparedStatement ps=con.prepareStatement
        		("SELECT * FROM richieste WHERE user_ricev=?");
        		
        ps.setString(1, user);
        
        
        ResultSet rs =ps.executeQuery();
        String user_ric = new String();
        while(rs.next())
        {
        	

        	
        	user_ric = rs.getString("user_ric");
        	myFriends.add(user_ric);
        	//request.setAttribute("user_ric",user_ric);
        	out.print(user_ric + " <a id=\"add\" href="+"AcceptFriend"+">Aggiungi</a>"+"</br>");
        	session.setAttribute("user_ric",user_ric);
        	
        }
        
        
        //for(Utente u: myFriends)
            //out.println(u + "</br>");
        
            
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
