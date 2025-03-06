

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String user = request.getParameter("user");
        String password = request.getParameter("password");
        if (user==null || user.equals("") || password==null || password.equals("")) {
            response.sendRedirect("login0304.html");
        } else {
        	HttpSession hs=request.getSession();
        	hs.setAttribute("username", user);
        	hs.setAttribute("userpassword", password);
        	//response.getWriter().append("User Session Created");
        	
        	//request.getSession().setAttribute("login", user);
        	request.getRequestDispatcher("/user.view").forward(request, response);
        	//request.getRequestDispatcher("/userpassword.jsp").forward(request, response);

        }
	}
}
