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
@WebServlet("/AddFriend")
public class AddFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //request.getRequestDispatcher("friend_list.jsp").include(request, response);  
        
        
        String id = request.getParameter("id");
        HttpSession session=request.getSession(false);  
        
        if(session!=null){
        	
        String nome=(String)session.getAttribute("id");  
        if(!id.equals(nome)){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con3=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/esempio","root","01072014");

        PreparedStatement ps2=con3.prepareStatement
        		("SELECT * FROM amicizie WHERE (user_1 =? AND user_2=?) OR (user_1 =? AND user_2=?)");
        		
        ps2.setString(1, id);
        ps2.setString(2, nome);
        ps2.setString(3, nome);
        ps2.setString(4, id);
        ResultSet rs =ps2.executeQuery();
        if(!rs.next()){
        	
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/esempio","root","01072014");

        PreparedStatement ps=con.prepareStatement
        		("INSERT INTO richieste (user_ric,user_ricev) VALUES (?,?)");
        		
        ps.setString(1, nome);
        ps.setString(2, id);
        
        int i=ps.executeUpdate();
        
        if(i>0)
        {
        	out.println("Friend request successfully sent");
        }
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        out.close(); 
        }
        else
        	out.println("Friend already added!" +" <a id=\"add\" href="+"Friends.jsp"+">back</a>"+"</br>");
        	}catch(Exception e)
        {	out.println("Friend already added!" +" <a id=\"add\" href="+"Friends.jsp"+">back</a>"+"</br>");
            e.printStackTrace();
        }
        out.close(); 
        
	}
        else{
    		out.println("Non puoi aggiungere te stesso!!" +" <a id=\"add\" href="+"Friends.jsp"+">back</a>"+"</br>");
    		out.close(); }}
		
}
}
