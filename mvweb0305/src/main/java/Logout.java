import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet(name="Logout", urlPatterns={"/logout.do"})
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest req,
        HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("login0304.html");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
        //req.getSession().invalidate();
        //resp.sendRedirect("login0304.html");
    } 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }
}
