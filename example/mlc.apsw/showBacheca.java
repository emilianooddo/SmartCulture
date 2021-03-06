

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
@WebServlet("/showBacheca")
public class showBacheca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showBacheca() {
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
        String user1 = new String();
        String user2 = new String();
        List<Utente> myFriends = new ArrayList<Utente>();
        List<String> luoghi = new ArrayList<String>();
        String user;
        HttpSession session=request.getSession(false);  
        
         user=(String)session.getAttribute("id");
        
        try{


           Class.forName("com.mysql.jdbc.Driver");

 
           	Connection con=DriverManager.getConnection
                          ("jdbc:mysql://localhost:3306/esempio","root","01072014");
           
	  				PreparedStatement ps =con.prepareStatement
            ("SELECT anagrafica.nome,anagrafica.cognome,anagrafica.id,luoghi.maps.nome  FROM anagrafica,amicizie,luoghi.maps,preferiti WHERE (((amicizie.user_2 =? AND (amicizie.user_1 = anagrafica.id))) OR ((amicizie.user_1 =? AND (amicizie.user_2 = anagrafica.id))) AND ((amicizie.user_1=preferiti.nick OR amicizie.user_2=preferiti.nick ) AND ((preferiti.lat = luoghi.maps.lat_x)AND(preferiti.lon=luoghi.maps.lat_y))))");
	  				
	  		ps.setString(1, user);
	  		ps.setString(2, user);
	  		ResultSet rs3 =ps.executeQuery();
           while(rs3.next()) {
        	   
        	   Utente u = new Utente();
        	   String luogo = new String();
               u.setNome(rs3.getString("nome"));
               u.setCognome(rs3.getString("cognome"));
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
          
           String s = "ciao";
           

           for(int i = 0; i <size;i++){
        	   nome[i]=utenti[i].getNome();
        	   cognome[i]=utenti[i].getCognome();
        	   places[i]=l[i];
        	   
           }
        	    
           
           request.setAttribute("nome", nome);
           request.setAttribute("cognome", cognome);
           request.setAttribute("places", places);
           RequestDispatcher dsp=request.getRequestDispatcher("/bacheca.jsp");
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
