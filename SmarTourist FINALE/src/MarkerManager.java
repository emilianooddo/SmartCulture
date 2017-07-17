import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/MarkerManager")
public class MarkerManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MarkerManager() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        String citta = request.getParameter("citta");
        String tipo = request.getParameter("tipo");
        List<Luogo> myElements = new ArrayList<Luogo>();
        int i=0;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/webappdb","root","root");

        PreparedStatement ps=con.prepareStatement
        		("SELECT * FROM location WHERE city=? and type=?");

        ps.setString(1, citta);
        ps.setString(2, tipo) ;
        
        ResultSet rs =ps.executeQuery();
        
        while (rs.next()) {
        	
        	String name = rs.getString("name_location");
        	String city = rs.getString("city");
        	String type = rs.getString("type");
        	String x = rs.getString("x_axis");   
        	String y = rs.getString("y_axis");  

        	Luogo l = new Luogo(name,city,type,x,y);
        	myElements.add(i,l);
        	
        	
        	        }
        int size = myElements.size();
        String[] coordinate_x = new String[size];
        String[] coordinate_y = new String[size];
        String[] nomi = new String[size];
        Luogo[] array = myElements.toArray(new Luogo[size]);
        
        for(i=0;i<size;i++){
        	coordinate_x[i] = array[i].getX();
        	coordinate_y[i] = array[i].getY();
        	nomi[i] = array[i].getNome();
        	}
       
        
       
        request.setAttribute("coordinate_x", coordinate_x);
        request.setAttribute("coordinate_y", coordinate_y);
        request.setAttribute("nomi", nomi);
        
        
        RequestDispatcher dsp=request.getRequestDispatcher("/result.jsp");
        dsp.forward(request,response);
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        out.close(); 
        }
}