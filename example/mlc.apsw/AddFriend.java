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
        
        String s = "elpitaz93@gmail.com";
        String id = request.getParameter("id");
        //String tipo = request.getParameter("tipo");
        
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/esempio","root","01072014");

        PreparedStatement ps=con.prepareStatement
        		("INSERT INTO richieste (user_ric,user_ricev) VALUES (?,?)");
        		
        ps.setString(1, s);
        ps.setString(2, id);
        
        int i=ps.executeUpdate();
        
        if(i>0)
        {
        	out.println("Friend added successfully");
        }
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        out.close(); 
        }

}

