

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
                ("jdbc:mysql://localhost:3306/luoghi","root","01072014");

        PreparedStatement ps=con.prepareStatement
        		("SELECT * FROM maps WHERE citta =? and tipo=?");

        ps.setString(1, citta);
        ps.setString(2, tipo) ;
        
        ResultSet rs =ps.executeQuery();
        
        while (rs.next()) {
        	
        	float x = rs.getFloat("lat_x");   
        	float y = rs.getFloat("lat_y");  
        	String type = rs.getString("tipo");
        	String name = rs.getString("nome");
        	String city = rs.getString("citta");
        	Luogo l = new Luogo(city,x,y,type,name);
        	myElements.add(i,l);
        	
        	
        	        }
        int size = myElements.size();
        float[] coordinate_x = new float[size];
        float[] coordinate_y = new float[size];
        Luogo[] array = myElements.toArray(new Luogo[size]);
        
        for(i=0;i<size;i++){
        	coordinate_x[i] = array[i].getX();
        	coordinate_y[i] = array[i].getY();
        	
        	
        }
        
        /*for(i=0;i<size;i++){
          out.println(coordinate_x[i]);  
        out.println(coordinate_y[i]);  }*/
        request.setAttribute("coordinate_x", coordinate_x);
        request.setAttribute("coordinate_y", coordinate_y);
        request.setAttribute("size", size);
        
        
        RequestDispatcher dsp=request.getRequestDispatcher("/result2.jsp");
        dsp.forward(request,response);
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        

        //Luogo[] array = myElements.toArray(new Luogo[myElements.size()]);
        //for(i=0;i<myElements.size();i++)
        //out.println(array[i] + "<br>");
        }
}
