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
 * Servlet implementation class showBacheca
 */
@WebServlet("/showNoticeBoard")
public class showNoticeBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showNoticeBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out=response.getWriter();  
		
        response.setContentType("text/html;charset=UTF-8");

        List<Utente> myFriends = new ArrayList<Utente>();
        List<String> luoghi = new ArrayList<String>();
        String user;
        HttpSession session=request.getSession(false);  
        
         user=(String)session.getAttribute("username");
        
        try{


           Class.forName("com.mysql.jdbc.Driver");

 
           	Connection con=DriverManager.getConnection
                          ("jdbc:mysql://localhost:3306/webappdb","root","root");
           
	  				PreparedStatement ps =con.prepareStatement
            ("SELECT user.avatar, user.name, user.surname, list_location.loc_name FROM user, friendship,list_location WHERE ((friendship.friend2 = list_location.user_loc AND (friendship.friend1 =? )) OR (friendship.friend1 = list_location.user_loc AND (friendship.friend2 =? ))) AND (list_location.user_loc=user.username) ORDER BY idList DESC");
	  				
	  		ps.setString(1, user);
	  		ps.setString(2, user);
	  		ResultSet rs3 =ps.executeQuery();
           while(rs3.next()) {
        	   
        	   Utente u = new Utente();
        	   String luogo = new String();
        	   u.setFoto(rs3.getString("avatar"));
               u.setNome(rs3.getString("name"));
               u.setCognome(rs3.getString("surname"));
               luogo = rs3.getString(4);
               myFriends.add(u);
               luoghi.add(luogo);
              }
           int size = myFriends.size();
           Utente[] utenti = myFriends.toArray(new Utente[size]);
           String[] l = luoghi.toArray(new String[size]);
           String[] nome = new String[size];
           String[] cognome= new String[size];
           String[] places = new String[size];
           String[] foto = new String[size];
           

           for(int i = 0; i <size;i++){
        	   foto[i]=utenti[i].getFoto();
        	   nome[i]=utenti[i].getNome();
        	   cognome[i]=utenti[i].getCognome();
          	   places[i]=l[i];       	   
           }
        	    
           request.setAttribute("foto", foto);
           request.setAttribute("nome", nome);
           request.setAttribute("cognome", cognome);
           request.setAttribute("places", places);
           RequestDispatcher dsp=request.getRequestDispatcher("homepage.jsp");
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
		doGet(request, response);
	}

}