

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class ShowClassNameController
 */
@WebServlet("/showclassname.do")
public class ShowClassNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    User user=new User();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowClassNameController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext context=super.getServletContext();
		InputStream in=context.getResourcePaths("WEB-INF/persons.txt");
		//List<User> data=new ArrayList<>{};
		List<User> data=datafFromFile(in);
		try {
			InputStreamReader sr=new InputStreamReader();
			BufferRear br= new BufferedReader(sr);
			String line=null;
		}catch(Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
