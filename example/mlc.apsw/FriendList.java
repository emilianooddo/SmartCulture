

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/FriendList")
public class FriendList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("friend_list.jsp").include(request, response);  
        response.setContentType("text/html;charset=UTF-8");
       
        List<Utente> myFriends = new ArrayList<Utente>();
        String user;
        HttpSession session=request.getSession(false);  
        if(session!=null){  
         user=(String)session.getAttribute("id");
        
        try{

  	 //loading drivers for mysql
           Class.forName("com.mysql.jdbc.Driver");

   	 //creating connection with the database 
           Connection con=DriverManager.getConnection
                          ("jdbc:mysql://localhost:3306/esempio","root","01072014");
           PreparedStatement ps =con.prepareStatement
                               ("SELECT * FROM amicizie WHERE user_1 =? OR user_2=?");
           ps.setString(1, user);
           ps.setString(2, user) ;
           ResultSet rs =ps.executeQuery();
           
           
           while(rs.next()) {
        	   //request.getRequestDispatcher("index2.jsp").include(request, response);  
        	   Utente u = new Utente();
               u.setNome(rs.getString("nome"));
               u.setCognome(rs.getString("cognome"));
               myFriends.add(u);
              }
           
           
           for(Utente u: myFriends)
               out.println(u + "</br>");
           
  }catch(Exception e)
        {
            e.printStackTrace();
        }
                            
        out.close();  }
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Utente> myFriends = new ArrayList<Utente>();
        String user;
        HttpSession session=request.getSession(false);  
        if(session!=null){  
         user=(String)session.getAttribute("user");
        
        try{

  	 //loading drivers for mysql
           Class.forName("com.mysql.jdbc.Driver");

   	 //creating connection with the database 
           Connection con=DriverManager.getConnection
                          ("jdbc:mysql://localhost:3306/esempio","root","01072014");
           PreparedStatement ps =con.prepareStatement
                               ("SELECT * FROM amicizie WHERE user_1 =? OR user_2=?");
           ps.setString(1, user);
           ps.setString(2, user) ;
           ResultSet rs =ps.executeQuery();
           
           
           if(rs.next()) {
        	   //request.getRequestDispatcher("index2.jsp").include(request, response);  
        	   Utente u = new Utente();
               u.setNome(rs.getString("nome"));
               u.setCognome(rs.getString("cognome"));
               myFriends.add(u);
               
            	
            	
       
             
            }else
            {
                out.println("Username or Password incorrect");
                RequestDispatcher dsp = request.getRequestDispatcher("SimpleLogin.html");
                
                dsp.include(request, response);
             }
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
                            
        out.close();  }
	}

}
