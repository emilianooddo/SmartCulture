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

/**
 * Servlet implementation class ShowProfileUsers
 */
@WebServlet("/ShowProfileUsers")
public class ShowProfileUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProfileUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        String user = request.getParameter("searchfriends");

        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/webappdb","root","root");

        PreparedStatement ps=con.prepareStatement
        		("SELECT * FROM user WHERE username=? ");

        ps.setString(1, user);
        
        
        ResultSet rs =ps.executeQuery();
        
        if(rs.next()) {
        	

        	String username = rs.getString("username");
        	String name = rs.getString("name");
        	String surname = rs.getString("surname");
        	String email= rs.getString("email");
        	String birth = rs.getString("birth");
        	String avatar = rs.getString("avatar");
        	
        	request.setAttribute("username", username);	
        	request.setAttribute("name", name);
        	request.setAttribute("surname", surname);
        	request.setAttribute("email",email);
        	request.setAttribute("birth", birth);
        	request.setAttribute("avatar", avatar);
            
        	RequestDispatcher dsp=request.getRequestDispatcher("profileUsers.jsp");
            dsp.forward(request,response);
        	
  
        }
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
	}
}

