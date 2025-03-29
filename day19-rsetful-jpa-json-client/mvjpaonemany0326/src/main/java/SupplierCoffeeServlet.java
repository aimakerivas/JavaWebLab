

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.persistence.*;
import jakarta.persistence.Persistence;
import model.*;
import java.util.*;
/**
 * Servlet implementation class SupplierCoffeeServlet
 */
@WebServlet("/spcofadd")
public class SupplierCoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierCoffeeServlet() {
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
		Supplier s1=new Supplier();
		s1.setSupId(2);
		s1.setSupName("ABC Coffee");
		s1.setCity("Taipei");
		s1.setStreet("Kung Yuan Road");
		s1.setState("TW");
		s1.setZip("100");
		List<Coffee> data=new ArrayList<>();
		Coffee cf1=new Coffee();
		cf1.setCofName("Big Coffee C");
		cf1.setPrice(new BigDecimal(19.99));
		cf1.setSales(30);
		cf1.setTotal(30);
		cf1.setSupplier(s1);
		data.add(cf1);
		cf1=new Coffee();
		cf1.setCofName("Big Coffee D");
		cf1.setPrice(new BigDecimal(29.99));
		cf1.setSales(40);
		cf1.setTotal(40);
		cf1.setSupplier(s1);
		data.add(cf1);
		s1.setCoffees(data);
		mgr.getTransaction().begin();
		
		mgr.persist(s1);
		
		mgr.getTransaction().commit();
		response.getWriter().append("Save OK");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
