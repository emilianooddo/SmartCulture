

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
		request.getRequestDispatcher("Friends.jsp").include(request, response);   
        response.setContentType("text/html;charset=UTF-8");
        String user1 = new String();
        String user2 = new String();
        List<Utente> myFriends = new ArrayList<Utente>();
        String user;
        HttpSession session=request.getSession(false);  
        
         user=(String)session.getAttribute("id");
        
        try{


           Class.forName("com.mysql.jdbc.Driver");

 
           	Connection con=DriverManager.getConnection
                          ("jdbc:mysql://localhost:3306/esempio","root","01072014");
           
	  				PreparedStatement ps =con.prepareStatement
            ("SELECT anagrafica.*, amicizie.user_1 FROM anagrafica,amicizie WHERE ((amicizie.user_2 =? AND (amicizie.user_1 = anagrafica.id))) OR ((amicizie.user_1 =? AND (amicizie.user_2 = anagrafica.id)))");
	  				
	  		ps.setString(1, user);
	  		ps.setString(2, user);
	  		ResultSet rs3 =ps.executeQuery();
           while(rs3.next()) {
        	   //request.getRequestDispatcher("index2.jsp").include(request, response);  
        	   Utente u = new Utente();
               u.setNome(rs3.getString("nome"));
               u.setCognome(rs3.getString("cognome"));
               myFriends.add(u);
              }
          
           
           
           		for(Utente u: myFriends )
               out.println(u + "</br>");
           
  }catch(Exception e)
        {
            e.printStackTrace();
        }
                            
        out.close();  }
	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                            
        
	}

}
