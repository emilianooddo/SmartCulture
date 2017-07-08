

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

/**
 * Servlet implementation class FriendsManager
 */
@WebServlet("/FriendsManager")
public class FriendsManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendsManager() {
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
        
        
        String id = request.getParameter("id");
        //String tipo = request.getParameter("tipo");
        
        int i=0;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/esempio","root","01072014");

        PreparedStatement ps=con.prepareStatement
        		("SELECT * FROM anagrafica WHERE id =? ");

        ps.setString(1, id);
        
        
        ResultSet rs =ps.executeQuery();
        
        if(rs.next()) {
        	

        	String nickname = rs.getString("id");
        	String nome = rs.getString("nome");
        	String cognome = rs.getString("cognome");
        	Utente u = new Utente();
        	u.setNome(nome);
        	u.setCognome(cognome);
        	u.setTipo(nickname);

        	out.print(u);
  
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        out.close(); 
        }

}
