
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Coffee;

/**
 * Servlet implementation class CoffeeParamServlet
 */
@WebServlet("/coffeeparam")
public class CoffeeParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeeParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String p=request.getParameter("price");
		double price=0.0;
		if(p!=null && p!="") {
			price=Double.parseDouble(p);
		}
		String jpql="select c from Coffee c where c.price>= :arg1";
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvjpa0324");
		EntityManager mgr=factory.createEntityManager();
		TypedQuery<Coffee> tq=mgr.createQuery(jpql, Coffee.class);
		
		tq.setParameter("arg1", price); // query parameter
		
		List<Coffee> data=tq.getResultList();
		request.setAttribute("coffees", data);
		request.getRequestDispatcher("viewcoffees.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}