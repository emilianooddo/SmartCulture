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
@WebServlet("/FriendListUsers")
public class FriendListUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendListUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();  
		
        response.setContentType("text/html;charset=UTF-8");
        
        List<Utente> myFriends = new ArrayList<Utente>();
        String user =(String)request.getParameter("username");

        
        try{

           Class.forName("com.mysql.jdbc.Driver");

 
           	Connection con=DriverManager.getConnection
                          ("jdbc:mysql://localhost:3306/webappdb","root","root");
           
	  				PreparedStatement ps =con.prepareStatement
            ("SELECT user.*, friendship.friend1 FROM user,friendship WHERE ((friendship.friend2 =? AND (friendship.friend1 = user.username))) OR ((friendship.friend1 =? AND (friendship.friend2 = user.username)))");
	  				
	  		ps.setString(1, user);
	  		ps.setString(2, user);
	  		ResultSet rs3 =ps.executeQuery();
           while(rs3.next()) {
        	   //request.getRequestDispatcher("index2.jsp").include(request, response);  
        	   Utente u = new Utente();
               u.setNome(rs3.getString("name"));
               u.setCognome(rs3.getString("surname"));
               u.setUsername(rs3.getString("username"));
               myFriends.add(u);
              }
           
           int size = myFriends.size();
           String[] nome = new String[size];
           String[] cognome = new String[size];
           String[] username = new String[size];
           Utente[] friends_list = new Utente[size];
           friends_list = myFriends.toArray(new Utente[size]);
           
           for(int i=0;i<size;i++){
           	nome[i] = friends_list[i].getNome();
           	cognome[i] = friends_list[i].getCognome();
           	username[i] = friends_list[i].getUsername();
           	}
           
           request.setAttribute("nome", nome);
           request.setAttribute("cognome", cognome);
           request.setAttribute("username", username);
       	
           RequestDispatcher dsp=request.getRequestDispatcher("friend_listUsers.jsp");
           dsp.forward(request,response);
          
           
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