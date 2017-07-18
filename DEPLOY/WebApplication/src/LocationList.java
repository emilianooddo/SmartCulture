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
@WebServlet("/LocationList")
public class LocationList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();  
		
        response.setContentType("text/html;charset=UTF-8");
        
        List<Luogo> myLocations = new ArrayList<Luogo>();
        String usr;
        HttpSession session=request.getSession(false);  
        
        usr=(String)session.getAttribute("username");
        
        try{


           Class.forName("com.mysql.jdbc.Driver");

 
           	Connection con=DriverManager.getConnection
                          ("jdbc:mysql://localhost:3306/webappdb","root","apswpa");
           
	  				PreparedStatement ps =con.prepareStatement
            ("SELECT location.* FROM location, list_location WHERE (list_location.user_loc =?) AND (location.name_location=list_location.loc_name)");
	  				
	  		ps.setString(1, usr);
	  		
	  		ResultSet rs4 =ps.executeQuery();
           while(rs4.next()) {
 
        	   Luogo l = new Luogo();
               l.setNome(rs4.getString("name_location"));
               l.setCitta(rs4.getString("city"));
               myLocations.add(l);

              }
           
           int size = myLocations.size();
           String[] nome = new String[size];
           String[] citta = new String[size];

           Luogo[] locations_list = new Luogo[size];
           locations_list = myLocations.toArray(new Luogo[size]);
           
           for(int i=0;i<size;i++){
        	   nome[i] = locations_list[i].getNome();
        	   citta[i] = locations_list[i].getCitta();
           	}

           request.setAttribute("nome", nome);
           request.setAttribute("citta", citta);
       	
           
           RequestDispatcher dsp=request.getRequestDispatcher("location_list.jsp");
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