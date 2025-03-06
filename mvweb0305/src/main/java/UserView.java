import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet(name = "User", urlPatterns = {"/user.view"})
public class UserView extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("login") == null) {
            response.sendRedirect("login.html");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>歡迎 "
                    + session.getAttribute("login") + "</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet User  " +
                    session.getAttribute("login") + "</h1><br><br>");
            out.println("<a href=\"logout.do\">登出</a>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
//    	HttpSesion hs=hs.getSession();
//    	object objName=hs.getAttribute("username");
//    	Obkect objPassword=hs.getAttribue("userpassword");
//    	response.setContentType("text/html;charset=utf-8");
//    	if(objName!=null && objPassword!=null) {
//    		response.getWriter().append("Name:").append(objName.toString+"<br/>");
//    		response.getWriter().append("\nPassword:").append(objPassword.toString);
//        response.getWriter().append("<a href="logout.do"> Session失效 </a>");
        
//    	}
//    	else {
//    		response.getWriter().append("UserName or Password is null");
//    	}
    		
    } 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }
}
