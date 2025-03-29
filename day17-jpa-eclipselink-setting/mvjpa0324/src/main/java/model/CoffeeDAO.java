package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CoffeeDAO {
	static EntityManager mgr;
	public CoffeeDAO() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvjpa0324");
		mgr=factory.createEntityManager();
		
	}
	
	public void add(Coffee cof) {
		mgr.getTransaction().begin();
		try {			
			mgr.persist(cof);
			mgr.getTransaction().commit();
			System.out.println("addCoffee() ok");
		}catch(Exception ex)
		{
			System.out.println("addCoffee() error "+ex.getMessage());
			mgr.getTransaction().rollback();
		}
		
	}
}
