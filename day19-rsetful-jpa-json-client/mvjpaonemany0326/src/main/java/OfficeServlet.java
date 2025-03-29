

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.*;
import java.util.*;
import com.google.gson.*;

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
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvjpaonemany0326");
		EntityManager mgr=factory.createEntityManager();
		
		String jpql="select o from Office o";
		TypedQuery<Office> tq=mgr.createQuery(jpql, Office.class);
		List<Office> offices=tq.getResultList();
		Gson gson=new Gson();
		String jstr=gson.toJson(offices);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().append(jstr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
