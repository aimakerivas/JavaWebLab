

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
//import model.Coffee;
import model.Office;

/**
 * Servlet implementation class OfficeServlet
 */
@WebServlet("/offices")
public class OfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfficeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvjpa0325");
		EntityManager mgr=factory.createEntityManager();
//		TypedQuery<Office> tq=mgr.createNamedQuery("Office.findAll", Office.class);
//		List<Office> data=tq.getResultList();
//		request.setAttribute("offices", data);
//		request.getRequestDispatcher("officeView.jsp").forward(request, response);
		Office ofc=new Office();
		ofc.setOfficeCode("1");
		//ofc.setAddressLine1("100 Market Street");
		ofc.setAddressLine1("Kung Yuang Road");
		ofc.setAddressLine2("Suite 300");
		ofc.setCity("San Francisco");
		ofc.setCountry("USA");
		//ofc.setPhone("+1 650 219 4782");
		ofc.setPhone("02 23826015");
		ofc.setPostalCode("94080");
		ofc.setState("CA");
		ofc.setTerritory("NA");
		mgr.getTransaction().begin();
		Office find=mgr.find(Office.class,ofc.getOfficeCode());
		if(find!=null)
		{
			mgr.merge(ofc);
			mgr.getTransaction().commit();
			response.getWriter().append("Update OK");
		}else {
			mgr.getTransaction().rollback();
			response.getWriter().append("Update Failed");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
