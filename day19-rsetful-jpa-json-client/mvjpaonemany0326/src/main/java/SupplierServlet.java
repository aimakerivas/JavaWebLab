

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.persistence.*;
import model.*;
import java.util.*;

/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet("/suppliers")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvjpaonemany0326");
		EntityManager mgr=factory.createEntityManager();
		
		String jpql="select s from Supplier s where s.supId= :arg1";
		TypedQuery<Supplier> tq=mgr.createQuery(jpql, Supplier.class);
		tq.setParameter("arg1", 2);
		
		List<Supplier> data=tq.getResultList();
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(data.get(0).toString()+"<p>");
		List<Coffee> coffees =new ArrayList<>();
		coffees=data.get(0).getCoffees();
		
		mgr.close();
		response.getWriter().append(coffees.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
