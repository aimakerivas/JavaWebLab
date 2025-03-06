
import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import java.util.*;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    List<User> dataFromFile(InputStream in){
    	List<User> data=new ArrayList<>();
    	try {
    	   InputStreamReader sr=new InputStreamReader(in,"UTF-8");
    	   BufferedReader br=new  BufferedReader(sr);
    	   String line=null;
    	   while((line=br.readLine())!=null) {
    		   String[] arry=line.split(",");
    		   User u1=new User(arry[0],arry[1],Integer.parseInt(arry[2]));
    		   data.add(u1);
    	   }
    	   br.close();
    	}catch(Exception ex) {
    		System.out.println("dataFromFile error "+ex.getMessage());
    	}
    	return data;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext context=super.getServletContext();
		InputStream in=context.getResourceAsStream("WEB-INF/persons.txt");		
		List<User> data=dataFromFile(in);
		super.getServletContext().setAttribute("allUsers", data);
        //request.setAttribute("users", data);
        request.getRequestDispatcher("userview.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}