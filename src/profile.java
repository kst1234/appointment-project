

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class profile
 */
@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		if(session==null)
			out.println("No active accounts");
		else {
		String s=(String)session.getAttribute("user");
		String f=(String)session.getAttribute("fn");
		String l=(String)session.getAttribute("ln");
		
		out.println("<head>");
		out.println("<title>Profile</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">");
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
		out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>");
		out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>");
		out.println("<script src=\"https://use.fontawesome.com/e4aacdd27c.js\"></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<nav class=\"navbar navbar-expand-sm navbar-dark bg-dark fixed-top\">\r\n" + 
				"        <a href=\"#\" class=\"navbar-brand\">Profile Page</a>\r\n" + 
				"        <button class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#menu\">\r\n" + 
				"            <span class=\"navbar-toggler-icon\"></span>\r\n" + 
				"        </button>\r\n" + 
				"\r\n" + 
				"        <div class=\"collapse navbar-collapse\" id=\"menu\">\r\n" + 
				"            <span class=\"mr-auto\"></span>\r\n" + 
				"            <ul class=\"navbar-nav\">\r\n" + 
				"                <li class=\"nav-item\">\r\n" + 
				"                    <a href=\"Home.html\" class=\"nav-link\">\r\n" + 
				"                        <i class=\"fa fa-home\" aria-hidden=\"true\"></i>\r\n" + 
				"                        Home\r\n" + 
				"                    </a>\r\n" + 
				"                </li>\r\n" + 
				"                <li class=\"nav-item\">\r\n" + 
				"                    <a href=\"#\" class=\"nav-link\">\r\n" + 
				"                        <i class=\"fa fa-info\" aria-hidden=\"true\"></i>\r\n" + 
				"                        About Us\r\n" + 
				"                    </a>\r\n" + 
				"                </li>\r\n" + 
				"            </ul>\r\n" + 
				"        </div>\r\n" + 
				"    </nav>");
		out.println("<br>");
		out.println("<br>");
		out.println("<div class=\"container\" style=\"margin-left:450px;width:500px\">");
		out.println("<div class=\"card bg-important\" style=\"width:300px;\">");
		out.println("<div class=\"card-body\">");
		out.println("<h5>Profile of: "+s+"</h5><br><br>");
		out.println("</div>");
		out.println("<div class=\"card-footer\">");
		out.println("<br><br><p>Welcome "+s+"</p>");
		out.println("<br><p><b>Firstname:</b> "+f+"</p>");
		out.println("<br><p><b>Lastname:</b> "+l+"</p>");
		out.println("<br><br><a href=\"logout\">Logout</a> <i class=\"fa fa-sign-out\" aria-hidden=\"true\"></i>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
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
