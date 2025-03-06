

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import model.*;
/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Person> data=Arrays.asList(new Person("Mary","12345","Taipei"),
				new Person("Danny","45678","Taoyuan"),new Person("Teddy","13579","Kaohsiung"));
		//request.getSession().setAttribute("persons", data);
		//request.setAttribute("persons", data);
		ServletContext context=super.getServletContext();
		//InputStreamReader in=context.getResourcePaths("WEB-INF/persons.text");
		context.setAttribute("persons", data);
		//response.sendRedirect("person.jsp");
		request.getRequestDispatcher("person.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
