package model;

import java.util.List;

import jakarta.persistence.*;

public class EmployeeDAO {
	EntityManager manager;
	public EmployeeDAO() {
	  manager=Persistence.createEntityManagerFactory("mvRestJpaJson0326").createEntityManager();
	}
	public boolean removeEmployee(int no) {
		Employee e1=manager.find(Employee.class, no);
		manager.getTransaction().begin();
		if(e1!=null) {
		  try {	
		   manager.remove(e1);
		   manager.getTransaction().commit();
		   return true;
		  }catch(Exception ex) {
			  System.out.println("delete employee error "+ex.getMessage());
			  return false;
		  }
		}else {
			return false;
		}
	}
	public Employee updateEmployee(int no,Employee emp) {
		Employee e1=manager.find(Employee.class, no);
		manager.getTransaction().begin();
		if(e1!=null) {
		  try {	
		   Employee rs=manager.merge(emp);
		   manager.getTransaction().commit();
		   return rs;
		  }catch(Exception ex) {
			  System.out.println("update employee error "+ex.getMessage());
			  return null;
		  }
		}else {
			return null;
		}
	}
	public Employee findByName(String n) {
		List<Employee> list=getAll();
		return list.stream().filter(e1->e1.getFirstName().equalsIgnoreCase(n)).findAny().orElse(null);
	}
	public List<Employee> getAll(){
		String jpql="select e1 from Employee e1";
		TypedQuery<Employee> tq=manager.createQuery(jpql, Employee.class);
		return tq.getResultList();
	}
	public boolean addEmployee(Employee emp) {
	  Employee e1=manager.find(Employee.class, emp.getEmployeeNumber());
	  if(e1!=null) {
		  System.out.println("Employee Number Already Exists "+emp.getEmployeeNumber());
		  return false;
	  }
	  else {
		  manager.getTransaction().begin();
		  try {
			  manager.persist(emp);
			  manager.getTransaction().commit();
			  return true;
		  }catch(Exception ex) {
			  System.out.println("addEmployee error "+ex.getMessage());
		  }
		  return false;
	  }
	}
}