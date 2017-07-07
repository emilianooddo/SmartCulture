

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
        
        //request.getRequestDispatcher("SimpleSignin.html").include(request, response);  
        //request.getRequestDispatcher("profile.jsp").include(request, response);  
          
        
        
		HttpSession session = request.getSession(false);
		session.invalidate(); 
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        
		/*session.removeAttribute("nome");
		session.removeAttribute("cognome");
		session.removeAttribute("foto");
		session.removeAttribute("id");*/
        session.getMaxInactiveInterval();
		
		
		//session.getMaxInactiveInterval(); 
         
        
        
        
        out.println("Logout!Your session was destroyed successfully!!");
        request.getRequestDispatcher("SimpleSignin.html").include(request, response);  
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
