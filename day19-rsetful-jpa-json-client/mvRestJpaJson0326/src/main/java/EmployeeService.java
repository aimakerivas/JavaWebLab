import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;

@Path("/employees")
public class EmployeeService {
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_HTML+";charset=utf-8")
	public String hello() {
		return "Hello World";
	}
	
	@DELETE
	@Path("/userno/{no}")	
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("no")int n) {
		EmployeeDAO dao=new EmployeeDAO();
		boolean e1=dao.removeEmployee(n);
		if(e1)
			return Response.ok().entity("remove number "+n+" ok").build();
		else
			return Response.noContent().build();
	}
	
	@PUT
	@Path("/userno/{no}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@PathParam("no")int n,Employee emp) {
		EmployeeDAO dao=new EmployeeDAO();
		Employee e1=dao.updateEmployee(n,emp);
		if(e1!=null)
			return Response.ok().entity(e1).build();
		else
			return Response.noContent().build();
	}
	
	@GET
	@Path("/username/{firstName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByName(@PathParam("firstName")String n) {
		EmployeeDAO dao=new EmployeeDAO();
		Employee e1=dao.findByName(n);
		if(e1!=null)
			return Response.ok().entity(e1).build();
		else
			return Response.noContent().build();
	}
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmployee() {
		EmployeeDAO dao=new EmployeeDAO();
		List<Employee> emps=dao.getAll();
		if(emps.size()>0)
		 	return Response.ok().entity(emps).build();
		else
			return Response.noContent().build();
	}
    
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEmp(Employee emp) {
		EmployeeDAO dao=new EmployeeDAO();
		boolean f=dao.addEmployee(emp);
		if(f)
		 	return Response.ok().entity(emp).build();
		else
			return Response.noContent().build();
	}
}