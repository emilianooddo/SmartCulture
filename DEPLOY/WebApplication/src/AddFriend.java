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
 * Servlet implementation class AddFriend
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
        
        String user = request.getParameter("username");
        HttpSession session=request.getSession(false);  
        if(session!=null){
        	
        String name=(String)session.getAttribute("username");  
        if(!user.equals(name)){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con3=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/webappdb","root","apswpa");

        PreparedStatement ps2=con3.prepareStatement
        		("SELECT * FROM friendship WHERE (friend1 =? AND friend2=?) OR (friend1 =? AND friend2=?)");
        		
        ps2.setString(1, user);
        ps2.setString(2, name);
        ps2.setString(3, name);
        ps2.setString(4, user);
        ResultSet rs =ps2.executeQuery();
        if(!rs.next()){
        	
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/webappdb","root","apswpa");

        PreparedStatement ps=con.prepareStatement
        		("INSERT INTO request (sender,receiver) VALUES (?,?)");
        		
        ps.setString(1, name);
        ps.setString(2, user);
        
        int i=ps.executeUpdate();
        
        if(i>0)
        {
        	out.println("Richiesta di amicizia inviata con successo!");
        }
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        out.close(); 
        }
        else
        	out.println("Utente già aggiunto!" +" <a id=\"add\" href="+"friends.jsp"+">Indietro</a>"+"</br>");
        	}catch(Exception e)
        {	out.println("Utente già aggiunto!" +" <a id=\"add\" href="+"friends.jsp"+">Indietro</a>"+"</br>");
            e.printStackTrace();
        }
        out.close(); 
        
	}
        else{
    		out.println("Non puoi aggiungere te stesso!" +" <a id=\"add\" href="+"friends.jsp"+">Indietro</a>"+"</br>");
    		out.close(); }}
		
}
}