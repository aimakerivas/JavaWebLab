package model;

import jakarta.persistence.*;

public class CoffeeDAO {
	
	EntityManager mgr;
	public CoffeeDAO() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("mvjpa0325");
		mgr=factory.createEntityManager();
	}
	
    public void addCoffee(Coffee cof) {
    	mgr.getTransaction().begin();
    	try {
    		mgr.persist(cof);
    		mgr.getTransaction().commit();
    		System.out.println("addCoffee() OK");
    	}catch(Exception ex) {
    		System.out.println("addCoffee() error "+ex.getMessage());
    		
    	}
    }
    public Coffee updateCoffee(Coffee cof) {
    	mgr.getTransaction().begin();
    	try {
//    		Coffee  cf=mgr.merge(cof);
//    		mgr.getTransaction().commit();
//    		//mgr.persist(cof);    		
//    		System.out.println("updateCoffee() OK");
//    		return cf;
    		Coffee fd=mgr.find(Coffee.class, cof.getCofName());
    		System.out.println("find:"+fd);
    		if(fd!=null) {
    		  Coffee cf=mgr.merge(cof);
    		  mgr.getTransaction().commit();
    		  System.out.println("updateCoffee() OK");
    		  return cf;
    		}else {
    			return null;
    		}
    	}catch(Exception ex) {
    		System.out.println("updateCoffee() error "+ex.getMessage());
    		
    	}
    	return null;
    }
   
    public void removeCoffee(Coffee cof) {
    	mgr.getTransaction().begin();
    	try {
    		Coffee fd=mgr.find(Coffee.class, cof.getCofName());
    		System.out.println("find:"+fd);
    		if(fd!=null) {
    		  mgr.remove(cof);
    		  mgr.getTransaction().commit();
    		  System.out.println("removeCoffee() OK");
    		 
    		}
    		
    	}catch(Exception ex) {
    		System.out.println("removeCoffee() error "+ex.getMessage());    		
    	}
    	
    }
}
